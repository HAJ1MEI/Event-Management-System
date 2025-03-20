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
    public String listEvents(@RequestParam(required = false) String category, Model model) {
        List<Event> events;
        List<Event> recentEvents;
        List<Category> categories = categoryService.getAllCategories();
        
        if (category != null && !category.isEmpty()) {
            events = er.findByCategory(category);
        } else {
            events = er.findAll();
        }
        
        recentEvents = er.findTop5ByOrderByIdDesc();
        
        List<List<Category>> categoryGroups = new ArrayList<>();
        for (int i = 0; i < categories.size(); i += 3) {
            categoryGroups.add(categories.subList(i, Math.min(i + 3, categories.size())));
        }
        

        model.addAttribute("events", events);
        model.addAttribute("categoryGroups", categoryGroups);
        
        model.addAttribute("recentEvents", recentEvents);

        return "index";
    }


    @GetMapping("/new")
    public String showAddEventForm(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !loggedInUser.getRole().equals("ADMIN")) {
            return "redirect:/events";  // Redirect if user is not admin
        }

        model.addAttribute("event", new Event());
        model.addAttribute("categories", categoryService.getAllCategories());
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
                "Technology & Innovation",
                "Music & Entertainment",
                "Food & Lifestyle",
                "Adventure & Travel",
                "Education & Workshops",
                "Business & Networking",
                "Gaming & Pop Culture",
                "Others"
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
        return "index";
    }
}