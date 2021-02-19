package com.apirestful.Locar.controller;

import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());    
    }

}
