package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/user/{name}")
    public User user(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(value = "/user/add")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(value = "user/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }

    @GetMapping(value = "userData/{userId}")
    public JsonNode getUserData(@PathVariable int userId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();

        return node;
    }


}
