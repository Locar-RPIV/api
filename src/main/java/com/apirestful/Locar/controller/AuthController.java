package com.apirestful.Locar.controller;

import com.apirestful.Locar.Services.UserService;
import com.apirestful.Locar.model.Auth;
import com.apirestful.Locar.model.Response;
import com.apirestful.Locar.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    UserService userService;

    @SuppressWarnings("unchecked")
    @PostMapping("/auth")
    public <Any> Any auth(@RequestBody Auth auth) {
        String password = auth.getPassword();
        User user = userService.getUser(auth.getEmail()); 
        Response response = new Response();
        try {
            if (user == null) {
                response.setMessage("Usuário incorreto.");
                return (Any) new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            if (BCrypt.checkpw(user.getPassword(), password)) {
                return ((Any) user);
            }
            response.setMessage("Senha incorreta.");
            return (Any) new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
