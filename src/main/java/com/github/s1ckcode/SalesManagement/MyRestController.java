package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/user/{name}", method = RequestMethod.GET)
    public User user(@PathVariable String name) {
        return userRepository.findByName(name);
    }
}
