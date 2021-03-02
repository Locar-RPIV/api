package com.apirestful.Locar.Services;

import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User auth(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
