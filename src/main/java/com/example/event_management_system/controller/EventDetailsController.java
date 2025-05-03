package com.example.event_management_system.controller;

import com.example.event_management_system.entity.Event;
import com.example.event_management_system.entity.User;
import com.example.event_management_system.repository.EventRepository;
import com.example.event_management_system.service.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventDetailsController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private WishlistService wishlistService;

    
    @GetMapping("/details/{id}")
    public String showEventDetails(@PathVariable Long id, Model model) {
        Optional<Event> event = eventRepository.findById(id);
        event.ifPresent(value -> model.addAttribute("event", value));
        return "event-details";
    }

    
    @PostMapping("/wishlist/add/{eventId}")
    @ResponseBody
    public String addToWishlist(@PathVariable Long eventId, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login"; // Redirect to login if not logged in
        }
        wishlistService.addToWishlist(user.getId(), eventId);
        return "Product added to Wishlist!";
    }

    
    @GetMapping("/book/{eventId}")
    public String showBookingForm(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventRepository.findById(eventId);
        event.ifPresent(value -> model.addAttribute("event", value));
        return "ticket-booking-form";
    }
}
