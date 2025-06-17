package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.Otel;
import com.example.rezervasyon.repository.OtelRepository;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OtelController {

    @Autowired
    private OtelRepository otelRepository;

    // Uygulama başladığında varsayılan otelleri ekler
    @PostConstruct
    public void initOtel() {
        if (otelRepository.count() == 0) {
            Otel otel1 = new Otel();
            otel1.setAd("Papatya Otel");
            otel1.setKonum("İstanbul");
            otel1.setFiyat(500);

            Otel otel2 = new Otel();
            otel2.setAd("Deniz Manzaralı Otel");
            otel2.setKonum("Antalya");
            otel2.setFiyat(750);

            otelRepository.save(otel1);
            otelRepository.save(otel2);
        }
    }

    @GetMapping("/oteller")
    public String otelListesi(Model model, HttpSession session) {

        List<Otel> oteller = otelRepository.findAll();
        model.addAttribute("oteller", oteller);
        return "oteller"; // thymeleaf: oteller.html
    }
}
