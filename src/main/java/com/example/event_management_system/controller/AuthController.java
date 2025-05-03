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
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {  
            session.setAttribute("loggedInUser", user);  
            return "redirect:/events";  
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  
        return "redirect:/events"; 
    }
    
    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user,
                               @RequestParam String confirmPassword,
                               Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        
        // Basic password confirmation check
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        
        user.setRole("USER");
        
        userRepository.save(user);
        
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }
}

