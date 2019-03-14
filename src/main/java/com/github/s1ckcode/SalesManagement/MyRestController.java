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

import java.util.Optional;

@RestController
public class MyRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    @GetMapping(value = "/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value="/users/{name}")
    public User user(@PathVariable String name) {
        return userRepository.findByName(name);
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
     //   ((ObjectNode) node).put("hitRate",Utils.getHitrate(user));
      //  ((ObjectNode) node).put("avgSales",Utils.getAvgSales(user));
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
