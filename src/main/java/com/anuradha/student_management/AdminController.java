package com.anuradha.student_management;

import com.anuradha.student_management.repository.AdminRepository;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(
            AdminRepository adminRepository,
            PasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Signup Page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // Register Admin
    @PostMapping("/signup")
    public String registerAdmin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        try {
            String encodedPassword =
                    passwordEncoder.encode(password);

            adminRepository.saveAdmin(
                    username, encodedPassword);

            return "redirect:/login?registered";

        } catch (DuplicateKeyException e) {

            model.addAttribute("error",
                    "Username already exists!");

            return "signup";
        }
    }
}
