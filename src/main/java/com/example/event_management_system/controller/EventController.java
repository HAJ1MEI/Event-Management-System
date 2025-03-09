package com.example.event_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.event_management_system.entity.Event;
import com.example.event_management_system.service.EventService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String listEvents(Model model) {
        List<Event> allEvents = eventService.getAllEvents();
        List<Event> recentEvents = eventService.getRecentEvents(); // Get the latest 5 events

        model.addAttribute("events", allEvents);
        model.addAttribute("recentEvents", recentEvents);

        return "index";
    }


    @GetMapping("/new")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "add-event";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
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
    @PreAuthorize("hasAuthority('ADMIN')")
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