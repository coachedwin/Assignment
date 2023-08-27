package com.nagarro.azureAssignment1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nagarro.azureAssignment1.entity.User;
import com.nagarro.azureAssignment1.repo.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/msg")
    public String msg() {
        return "Azure Application running";
    }
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
    
    @GetMapping("/search")
    public List<User> searchUsersByLastName(@RequestParam("last_name") String lastName) {
        return userRepository.findByLastName(lastName);
    }
    
}


