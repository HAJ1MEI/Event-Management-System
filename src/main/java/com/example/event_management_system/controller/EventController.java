package com.example.event_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.event_management_system.entity.Category;
import com.example.event_management_system.entity.Event;
import com.example.event_management_system.entity.User;
import com.example.event_management_system.repository.EventRepository;
import com.example.event_management_system.service.CategoryService;
import com.example.event_management_system.service.EventService;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private EventRepository er;
    

    
    @GetMapping()
    public String homePage(@RequestParam(required = false) String category, Model model) {
        List<Event> events;
        List<Category> categories = categoryService.getAllCategories();
        
        if (category != null && !category.isEmpty()) {
            events = er.findByCategory(category);
        } else {
            events = er.findAll();
        }
        
        model.addAttribute("events", events);
        model.addAttribute("categories", categories); 
        
        return "home";
    }
    
    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Event> events = er.findAll();
        model.addAttribute("events", events);
        return "products";
    }
    
    @GetMapping("/contact")
    public String contactPage(Model model) {
        return "contact";
    }
    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }
    


    @GetMapping("/new")
    public String showAddEventForm(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !loggedInUser.getRole().equals("ADMIN")) {
            return "redirect:/events";  // Redirect if user is not admin
        }
        List<String> categories = List.of(
                "Living Room Furniture",
                "Bedroom Furniture",
                "Dining Room Furniture",
                "Office Furniture",
                "Outdoor Furniture",
                "Kids & Baby Furniture",
                "Storage & Organization",
                "Home Decor & Accessories",
                "Luxury & Premium Furniture"
            );

        model.addAttribute("event", new Event());
        model.addAttribute("categories", categories);
        return "add-event";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute Event event, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !loggedInUser.getRole().equals("ADMIN")) {
            return "redirect:/events";
        }

        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Optional<Event> event = eventService.getEventById(id);
        List<String> categories = List.of(
                "Living Room Furniture",
                "Bedroom Furniture",
                "Dining Room Furniture",
                "Office Furniture",
                "Outdoor Furniture",
                "Kids & Baby Furniture",
                "Storage & Organization",
                "Home Decor & Accessories",
                "Luxury & Premium Furniture"
            );
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            model.addAttribute("categories", categories);
            return "edit-event";
        }
        return "redirect:/events";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event updatedEvent) {
        updatedEvent.setId(id);
        eventService.saveEvent(updatedEvent);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

    @GetMapping("/search")
    public String searchEvents(@RequestParam String title, Model model) {
        List<Event> searchResults = eventService.searchEventsByTitle(title);
        model.addAttribute("events", searchResults);
        return "products";
    }
    
    @GetMapping("/category")
    public String eventsByCategory(@RequestParam String category, Model model) {
        List<Event> events = er.findByCategory(category);
        model.addAttribute("events", events);
        model.addAttribute("category", category);
        return "category"; // This corresponds to category.html
    }

}