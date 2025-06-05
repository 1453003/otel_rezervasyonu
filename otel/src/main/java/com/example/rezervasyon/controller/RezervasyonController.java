package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.Otel;
import com.example.rezervasyon.model.Rezervasyon;
import com.example.rezervasyon.repository.OtelRepository;
import com.example.rezervasyon.repository.RezervasyonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RezervasyonController {

    @Autowired
    private OtelRepository otelRepository;

    @Autowired
    private RezervasyonRepository rezervasyonRepository;

    @GetMapping("/rezervasyon")
    public String rezervasyonForm(@RequestParam Long otelId, Model model) {
        Otel otel = otelRepository.findById(otelId).orElse(null);
        Rezervasyon rezervasyon = new Rezervasyon();
        rezervasyon.setOtel(otel);

        model.addAttribute("rezervasyon", rezervasyon);
        return "rezervasyon";
    }

    @PostMapping("/rezervasyon")
    public String rezervasyonKaydet(@ModelAttribute Rezervasyon rezervasyon) {
        rezervasyonRepository.save(rezervasyon);
        return "redirect:/oteller";
    }
}
