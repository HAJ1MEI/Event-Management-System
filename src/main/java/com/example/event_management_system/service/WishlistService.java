package com.example.event_management_system.service;

import com.example.event_management_system.entity.Wishlist;
import com.example.event_management_system.entity.Event;
import com.example.event_management_system.entity.User;
import com.example.event_management_system.repository.WishlistRepository;
import com.example.event_management_system.repository.EventRepository;
import com.example.event_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public void addToWishlist(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElseThrow();
        Event event = eventRepository.findById(eventId).orElseThrow();
        Wishlist wishlist = new Wishlist(user, event);
        wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getUserWishlist(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
    
    public void deleteWishlistItem(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }
}
