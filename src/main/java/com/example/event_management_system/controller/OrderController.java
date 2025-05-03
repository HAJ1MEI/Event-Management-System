package com.example.event_management_system.controller;

import com.example.event_management_system.entity.Order;
import com.example.event_management_system.entity.User;
import com.example.event_management_system.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String viewOrders(HttpSession session, Model model) {
        // Check if the user is logged in
        Object userObj = session.getAttribute("loggedInUser");
        if (userObj == null || !(userObj instanceof User)) {
            return "redirect:/login";
        }

        User user = (User) userObj; // Safe casting
        List<Order> orders = orderService.getOrdersByUser(user.getUsername());
        model.addAttribute("orders", orders);
        
        return "orders"; 
    }
}
