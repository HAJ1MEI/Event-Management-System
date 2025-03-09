package com.example.event_management_system.controller;

import com.example.event_management_system.entity.Event;
import com.example.event_management_system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class EventDetailsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events/details/{id}")
    public String showEventDetails(@PathVariable Long id, Model model) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "event-details"; // Redirect to the new event details page
        }
        return "redirect:/events";
    }
}

