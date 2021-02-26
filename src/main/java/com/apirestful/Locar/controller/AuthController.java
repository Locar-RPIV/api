package com.apirestful.Locar.controller;

import com.apirestful.Locar.model.Auth;
import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody Auth auth) {
        return userRepository.findByEmailAndPassword(auth.getEmail(), auth.getPassword());    
    }

}
