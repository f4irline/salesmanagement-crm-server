package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
            return 1.0;
        } else if(sales == 0) {
            return 0.0;
        }
        return sales / contacts;
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
        return salesValue / salesCount;
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

    public static String hashMyPassword(String password) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }


}
