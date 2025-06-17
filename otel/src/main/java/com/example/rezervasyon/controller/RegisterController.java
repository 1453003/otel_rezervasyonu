package com.example.rezervasyon.controller;

import com.example.rezervasyon.model.User;
import com.example.rezervasyon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerForm() {
        return "register";  // resources/templates/register.html dosyasını gösterecek
    }

    @PostMapping("/register")
    public String registerSubmit(@RequestParam String username,
                                 @RequestParam String password,
                                 Model model) {
        // Kullanıcı adı önceden varsa hata göster
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("error", "Bu kullanıcı adı zaten kayıtlı!");
            return "register";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // NOT: Prod ortamda password hash'lenmeli!
        newUser.setRole("user");       // Burada rolü "user" olarak ayarlıyoruz

        userRepository.save(newUser);

        return "redirect:/login"; // Kayıt sonrası giriş sayfasına yönlendir
    }

}
