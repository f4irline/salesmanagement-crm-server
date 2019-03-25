package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    LeadRepository leadRepository;

    @GetMapping(value = "/userEvents/{userId}/")
    public Iterable<Iterable> getUserEvents(@PathVariable int userId) {
        Iterable<Iterable> userEvents = new ArrayList<>();

        User user = userRepository.findById(userId).get();

        ((ArrayList<Iterable>) userEvents).add(eventRepository.findEventsByEventTypeAndUser(Event.CONTACT,user));
        ((ArrayList<Iterable>) userEvents).add(eventRepository.findEventsByEventTypeAndUser(Event.MEETING,user));
        ((ArrayList<Iterable>) userEvents).add(eventRepository.findEventsByEventTypeAndUser(Event.OFFER,user));
        ((ArrayList<Iterable>) userEvents).add(eventRepository.findEventsByEventTypeAndUser(Event.SALE,user));
        ((ArrayList<Iterable>) userEvents).add(leadRepository.findAll());

        return userEvents;
    }



}
