package com.example.rezervasyon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String anasayfaYonlendir() {
        return "redirect:/oteller";
    }
}
