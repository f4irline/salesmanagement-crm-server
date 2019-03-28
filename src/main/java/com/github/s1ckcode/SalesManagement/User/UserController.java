package com.github.s1ckcode.SalesManagement.User;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

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
        User user = userRepository.findById(userId).get();

        return utils.getUserData(user);
    }

    @GetMapping(value = "/userData/all")
    public Iterable<JsonNode> getAllUsersData() {
        Iterable<User> users = userRepository.findAll();
        List<JsonNode> entities= new ArrayList<>();

        for(User user: users) {
            entities.add(utils.getUserData(user));
        }

        return entities;
    }

    @GetMapping(value="/userData/all/{startDate}/{endDate}")
    public Iterable<JsonNode> getAllUsersDataBetween(@PathVariable String startDate, @PathVariable String endDate) {
        ObjectMapper mapper = new ObjectMapper();
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        Iterable<User> users = userRepository.findAll();
        List<JsonNode> entities = new ArrayList<>();

        for (User user: users) {
            JsonNode node = mapper.createObjectNode();
            ((ObjectNode) node).put("user_first",user.getUserFirst());
            ((ObjectNode) node).put("user_last",user.getUserLast());
            ((ObjectNode) node).put("hit_rate",utils.getHitrate(user, startLocalDate, endLocalDate));
            ((ObjectNode) node).put("avg_sales",utils.getAvgSales(user, startLocalDate, endLocalDate));
            ((ObjectNode) node).put("total_sales",utils.getAllSales(user, startLocalDate, endLocalDate));
            ((ObjectNode) node).put("contacts_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUserAndDateBetween(Event.CONTACT, user, startLocalDate, endLocalDate)).size());
            ((ObjectNode) node).put("meetings_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUserAndDateBetween(Event.MEETING, user, startLocalDate, endLocalDate)).size());
            ((ObjectNode) node).put("offers_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUserAndDateBetween(Event.OFFER, user, startLocalDate, endLocalDate)).size());
            ((ObjectNode) node).put("sales_amount", ((List<Event>)eventRepository.findEventsByEventTypeAndUserAndDateBetween(Event.SALE, user, startLocalDate, endLocalDate)).size());
            entities.add(node);
        }

        return entities;
    }

    @GetMapping(value = "/users/details")
    public UserDetails getDetails(Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else {
            return null;
        }
    }
}
