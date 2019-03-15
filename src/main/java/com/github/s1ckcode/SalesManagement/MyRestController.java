package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    Utils utils;

    @GetMapping(value = "/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value="/users/{userId}")
    public Optional<User> user(@PathVariable int userId) {
        return userRepository.findById(userId);
    }

    /*
    curl -H"Content-Type: application/json" -X POST -d {\"name\":\"mkyong\",\"role\":\"1\",\"password\":\"abc\"} http://localhost:8080/users/add
     */
    @PostMapping(value = "/users/add")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(value = "users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }

    @GetMapping(value = "/userData/{userId}")
    public JsonNode getUserData(@PathVariable int userId) {
        Optional<User> user = userRepository.findById(userId);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("hitRate",utils.getHitrate(user));
        ((ObjectNode) node).put("avgSales",utils.getAvgSales(user));
        ((ObjectNode) node).put("allSales",utils.getAllSales(user));
        ((ObjectNode) node).put("contactCount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.CONTACT, user)).size());
        ((ObjectNode) node).put("meetingCount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.MEETING, user)).size());
        ((ObjectNode) node).put("offerCount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.OFFER, user)).size());
        ((ObjectNode) node).put("salesCount", ((List<Event>)eventRepository.findEventsByEventTypeAndUser(Event.SALE, user)).size());


        return node;
    }

    @GetMapping(value = "/events/{userId}")
    public Iterable<Event> getAllEventsFromUser(@PathVariable int userId) {
        return eventRepository.findEventsByUser(userRepository.findById(userId));
    }

    @GetMapping(value = "/events")
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }


}
