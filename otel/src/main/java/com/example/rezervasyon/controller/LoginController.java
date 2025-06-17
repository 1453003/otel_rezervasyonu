package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.User;
import com.example.rezervasyon.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/oteller";
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            model.addAttribute("error", "Kullanıcı bulunamadı. Lütfen kayıt olunuz.");
            return "login";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Hatalı şifre. Lütfen tekrar deneyiniz.");
            return "login";
        }

        session.setAttribute("user", user);

        // Kullanıcı admin ise admin paneline, değilse otellere yönlendir
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin/oteller";
        } else {
            return "redirect:/oteller";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
