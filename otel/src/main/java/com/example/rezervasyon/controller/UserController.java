package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.User;
import com.example.rezervasyon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

}
