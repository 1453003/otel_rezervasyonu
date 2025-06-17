package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.User;
import com.example.rezervasyon.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/personel")
public class PersonelController {

    @Autowired
    private UserRepository userRepository;

    // Personel ekleme formu göster
    @GetMapping("/ekle")
    public String personelEkleForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/personel_form";
    }

    // Personel kaydetme işlemi
    @PostMapping("/ekle")
    public String personelEkleSubmit(@ModelAttribute("user") @Valid User user,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/personel_form";
        }

        // Kullanıcı adı zaten varsa hata döner
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Bu kullanıcı adı zaten kayıtlı!");
            return "admin/personel_form";
        }

        // Eğer rol boşsa "USER" olarak ayarla
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }

        // Şifreyi hashlemek daha iyi olur, şu an düz kayıt
        userRepository.save(user);

        return "redirect:/admin/kullanicilar"; // Kayıt sonrası kullanıcı listesine yönlendir
    }
}
