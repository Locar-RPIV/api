package com.apirestful.Locar.controller;

import com.apirestful.Locar.Services.UserService;
import com.apirestful.Locar.model.Auth;
import com.apirestful.Locar.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/auth")
    public User auth(@RequestBody Auth auth) {
        return userService.auth(auth.getEmail(), auth.getPassword());    
    }

}
