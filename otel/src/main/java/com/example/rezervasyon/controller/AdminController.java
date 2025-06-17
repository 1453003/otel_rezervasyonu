package com.example.rezervasyon.controller;
import com.example.rezervasyon.repository.RezervasyonRepository;
import com.example.rezervasyon.model.Otel;
import com.example.rezervasyon.model.User;
import com.example.rezervasyon.repository.OtelRepository;
import com.example.rezervasyon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OtelRepository otelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RezervasyonRepository rezervasyonRepository;

    @GetMapping("/oteller")
    public String otelListesi(Model model) {
        model.addAttribute("oteller", otelRepository.findAll());
        return "admin/otel_listesi";
    }

    @GetMapping("/oteller/ekle")
    public String otelEkleForm(Model model) {
        model.addAttribute("otel", new Otel());
        return "admin/otel_form";
    }

    @PostMapping("/oteller/ekle")
    public String otelEkle(@ModelAttribute Otel otel) {
        otelRepository.save(otel);
        return "redirect:/admin/oteller";
    }

    @GetMapping("/oteller/guncelle/{id}")
    public String otelGuncelleForm(@PathVariable Long id, Model model) {
        Otel otel = otelRepository.findById(id).orElse(null);
        model.addAttribute("otel", otel);
        return "admin/otel_form";
    }

    @PostMapping("/oteller/guncelle")
    public String otelGuncelle(@ModelAttribute Otel otel) {
        otelRepository.save(otel);
        return "redirect:/admin/oteller";
    }

    @GetMapping("/oteller/sil/{id}")
    public String otelSil(@PathVariable Long id) {
        otelRepository.deleteById(id);
        return "redirect:/admin/oteller";
    }

    @GetMapping("/kullanicilar")
    public String kullanicilariGoruntule(Model model) {
        model.addAttribute("kullanicilar", userRepository.findAll());
        return "admin/kullanici_listesi";
    }


    @GetMapping("/rezervasyonlar")
    public String rezervasyonlariGoruntule(Model model) {
        model.addAttribute("rezervasyonlar", rezervasyonRepository.findAll());
        return "admin/admin_rezervasyonlar";
    }

}
