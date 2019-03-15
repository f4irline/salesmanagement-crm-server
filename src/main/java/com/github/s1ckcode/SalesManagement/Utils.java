package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.s1ckcode.SalesManagement.Company.CompanyRepository;
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
import java.util.Optional;

import static com.github.s1ckcode.SalesManagement.Event.Event.CONTACT;
import static com.github.s1ckcode.SalesManagement.Event.Event.SALE;
import static java.time.temporal.ChronoUnit.DAYS;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;

@Component
public class Utils {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CompanyRepository companyRepository;

    public double getHitrate(User user) {
        double contacts = 0;
        double sales = 0;

        Iterable<Event> events = (eventRepository.findEventsByUser(user));
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

    public double getAvgSales(User user) {
        double salesCount = 0;
        double salesValue = 0;
        Iterable<Event> events = (eventRepository.findEventsByUser(user));
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

    public double getAllSales(User user) {
        double salesValue = 0;
        Iterable<Event> events = (eventRepository.findEventsByUser(user));
        for(Event event:events) {
            if(event.getEventType() == SALE) {
                salesValue += event.getSum();
            }
        }
        return salesValue;
    }

    public Iterable<JsonNode> getCompanyChart(Month month) {
        YearMonth yearMonth = YearMonth.of(2019,2);
        int daysInMonth = yearMonth.lengthOfMonth();

        ObjectMapper mapper = new ObjectMapper();

        double wholeSum = 0;
        int monthNum = 1; //THIS IS GOING TO BE GIVEN MONTH IN INTEGER 1-12
        double wholeGoal = companyRepository.getMonthlyGoalByMonth(month);
        double dailyGoal = wholeGoal/daysInMonth;
        double goal = 0;
        int previousDate = 1;

        Iterable<Event> events = eventRepository.findEventsByDateMonth(month);
        List<JsonNode> entities= new ArrayList<>();
        for(Event event: events) {

            goal += (event.getDate().getDayOfMonth() - previousDate) * dailyGoal;
            previousDate = event.getDate().getDayOfMonth();

            JsonNode node = mapper.createObjectNode();
            ((ObjectNode) node).put("date",event.getDate().toString());
            ((ObjectNode) node).put("sum", wholeSum += event.getSum());
            ((ObjectNode) node).put("goal", goal);
            entities.add(node);
        }
        return entities;
    }

    public static String hashMyPassword(String password) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }
}
