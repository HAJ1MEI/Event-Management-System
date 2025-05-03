package com.example.event_management_system.controller;

import com.example.event_management_system.entity.Wishlist;
import com.example.event_management_system.service.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/wishlist")
    public String showWishlist(HttpSession session, Model model) {
        Object userObj = session.getAttribute("loggedInUser");
        if (userObj == null) {
            return "redirect:/login";
        }
        Long userId = ((com.example.event_management_system.entity.User) userObj).getId();
        List<Wishlist> wishlist = wishlistService.getUserWishlist(userId);
        model.addAttribute("wishlist", wishlist);
        return "wishlist";
    }
    
    
    @GetMapping("/wishlist/delete/{id}")
    public String deleteWishlistItem(@PathVariable Long id, HttpSession session) {
        wishlistService.deleteWishlistItem(id);
        return "redirect:/wishlist";
    }
}
