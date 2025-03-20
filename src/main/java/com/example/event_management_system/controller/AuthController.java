package com.example.event_management_system.controller;


import com.example.event_management_system.entity.User;
import com.example.event_management_system.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Redirects to login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {  // Plain-text password check (hash it in production)
            session.setAttribute("loggedInUser", user);  // Store user session
            return "redirect:/events";  // Redirect to home page
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on login page if authentication fails
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Clear session
        return "redirect:/login"; // Redirect to login page
    }
}

