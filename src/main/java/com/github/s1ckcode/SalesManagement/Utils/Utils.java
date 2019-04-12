package com.github.s1ckcode.SalesManagement.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.s1ckcode.SalesManagement.Company.CompanyGoal;
import com.github.s1ckcode.SalesManagement.Company.CompanyGoalRepository;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static com.github.s1ckcode.SalesManagement.Event.Event.CONTACT;
import static com.github.s1ckcode.SalesManagement.Event.Event.SALE;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CompanyGoalRepository companyGoalRepository;

    public double getHitrate(User user, LocalDate startDate, LocalDate endDate) {
        Iterable<Event> events = (eventRepository.findEventsByUserAndDateBetween(user, startDate, endDate));
        return calculateHitRate(events);
    }

    public double getHitrate(User user) {
        Iterable<Event> events = (eventRepository.findEventsByUser(user));
        return calculateHitRate(events);
    }

    private double calculateHitRate(Iterable<Event> events) {
        double contacts = 0;
        double sales = 0;

        for(Event event:events) {
            if(event.getEventType() == SALE) {
                sales++;
            }
            else if(event.getEventType() == CONTACT) {
                contacts++;
            }
        }
        if(contacts == 0 && sales >0) {
            return 100.0;
        } else if(sales == 0) {
            return 0.0;
        }

        double procents = (sales / contacts)*100.0;
        return Math.round(procents * 100.0) /100.0;
    }

    public double getAvgSales(User user, LocalDate startDate, LocalDate endDate) {
        Iterable<Event> events = (eventRepository.findEventsByUserAndDateBetween(user, startDate, endDate));
        return calculateAvgSales(events);
    }

    public double getAvgSales(User user) {
        Iterable<Event> events = (eventRepository.findEventsByUser(user));
        return calculateAvgSales(events);
    }

    private double calculateAvgSales(Iterable<Event> events) {
        double salesCount = 0;
        double salesValue = 0;

        for(Event event:events) {
            if(event.getEventType() == SALE) {
                salesCount++;
                salesValue += event.getSum();
            }
        }
        if(salesCount == 0) {
            return 0.0;
        }
        double avgSales = salesValue / salesCount;
        return Math.round(avgSales * 100.0) /100.0;
    }

    public double getAllSales(User user, LocalDate startDate, LocalDate endDate) {
        Iterable<Event> events = (eventRepository.findEventsByUserAndDateBetween(user, startDate, endDate));
        return calculateSales(events);
    }

    public double getAllSales(User user) {
        Iterable<Event> events = (eventRepository.findEventsByUser(user));
        return calculateSales(events);
    }

    public double getMonthlySales(User user) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.of(endDate.getYear(), endDate.getMonth(),1);
        Iterable<Event> events = (eventRepository.findEventsByUserAndDateBetween(user, startDate, endDate));
        return calculateSales(events);
    }

    private double calculateSales(Iterable<Event> events) {
        double salesValue = 0;

        for(Event event:events) {
            if(event.getEventType() == SALE) {
                salesValue += event.getSum();
            }
        }
        return salesValue;
    }

    public Iterable<JsonNode> getCompanyChartData(LocalDate startDate, LocalDate endDate) {
        ObjectMapper mapper = new ObjectMapper();

        double wholeSum = 0;
        double wholeGoal = 0;

        Month month = startDate.getMonth();
        YearMonth yearMonth = YearMonth.of(startDate.getYear(),startDate.getMonth());
        CompanyGoal companyGoal = companyGoalRepository.findCompanyGoalByYearMonth(yearMonth);

        if(companyGoal != null) {
            wholeGoal = companyGoal.getMonthlyGoal();
        }

        int daysInMonth = yearMonth.lengthOfMonth();
        double dailyGoal = wholeGoal/daysInMonth;
        double goal = 0;

        List<JsonNode> entities= new ArrayList<>();

        for(LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusDays(1)) {
            Iterable<Event> events = eventRepository.findEventsByDate(date);
            for(Event event : events) {
                wholeSum += event.getSum();
            }
            if(date.getMonth() == month) {
                goal += dailyGoal;
            } else {
                month = date.getMonth();
                companyGoal = companyGoalRepository.findCompanyGoalByYearMonth(YearMonth.of(date.getYear(),date.getMonth()));
                if(companyGoal != null) {
                    wholeGoal = companyGoal.getMonthlyGoal();
                } else {
                    wholeGoal = 0;
                }
                yearMonth = YearMonth.of(date.getYear(),date.getMonth());
                daysInMonth = yearMonth.lengthOfMonth();
                dailyGoal = wholeGoal/daysInMonth;
                goal += dailyGoal;
            }
            JsonNode node = mapper.createObjectNode();
            ((ObjectNode) node).put("date",date.toString());
            ((ObjectNode) node).put("sum", Math.round(wholeSum * 100.0) / 100.0);
            ((ObjectNode) node).put("goal", Math.round(goal * 100.0) / 100.0);
            entities.add(node);
        }
        return entities;
    }

    public JsonNode getUserData(User user) {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("user_first",user.getUserFirst());
        ((ObjectNode) node).put("user_last",user.getUserLast());
        ((ObjectNode) node).put("hit_rate", getHitrate(user));
        ((ObjectNode) node).put("avg_sales", getAvgSales(user));
        ((ObjectNode) node).put("total_sales", getAllSales(user));
        ((ObjectNode) node).put("monthly_sales", getMonthlySales(user));
        ((ObjectNode) node).put("contacts_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.CONTACT, user)).size());
        ((ObjectNode) node).put("meetings_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.MEETING, user)).size());
        ((ObjectNode) node).put("offers_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.OFFER, user)).size());
        ((ObjectNode) node).put("sales_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.SALE, user)).size());

        return node;
    }

    public static String hashMyPassword(String password) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }
}
