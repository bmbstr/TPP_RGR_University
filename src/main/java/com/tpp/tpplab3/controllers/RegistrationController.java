package com.tpp.tpplab3.controllers;

import com.tpp.tpplab3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Додав цей метод, щоб відкривався файл registration.html
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    // Метод для відкриття твоєї нової сторінки login.html
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        String encodedPassword = passwordEncoder.encode(password);

        // Зберігаємо зашифрований пароль у базу
        userRepository.saveUser(username, encodedPassword, "ROLE_USER");

        // Повертаємо на логін з поміткою про успіх
        return "redirect:/login?registered";
    }
}