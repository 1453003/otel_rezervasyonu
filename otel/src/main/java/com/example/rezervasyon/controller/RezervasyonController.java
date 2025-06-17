package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.User;
import com.example.rezervasyon.model.Otel;
import com.example.rezervasyon.model.Rezervasyon;
import com.example.rezervasyon.repository.OtelRepository;
import com.example.rezervasyon.repository.RezervasyonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String rezervasyonKaydet(@ModelAttribute Rezervasyon rezervasyon, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        rezervasyon.setMusteriAdi(user.getUsername());
        rezervasyonRepository.save(rezervasyon);
        return "redirect:/rezervasyonlarim?success";
    }

    @GetMapping("/rezervasyonlarim")
    public String rezervasyonlarim(Model model, HttpSession session, @RequestParam(required = false) String success) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<Rezervasyon> rezervasyonlar = rezervasyonRepository.findByMusteriAdi(user.getUsername());
        model.addAttribute("rezervasyonlar", rezervasyonlar);
        model.addAttribute("success", success != null);
        return "rezervasyonlarim";
    }
}
