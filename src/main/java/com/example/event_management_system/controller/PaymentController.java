package com.example.event_management_system.controller;

import com.example.event_management_system.entity.User;
import com.example.event_management_system.service.OrderService;
import com.example.event_management_system.service.PaymentService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestParam int amount) {
        try {
            JSONObject orderJson = paymentService.createOrder(amount);
            return ResponseEntity.ok(orderJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/success")
    public String paymentSuccess() {
        return "success";  
    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePayment(@RequestBody Map<String, Object> data, HttpSession session) {
        try {
            // Retrieve logged-in user from session
            Object userObj = session.getAttribute("loggedInUser");
            if (userObj == null || !(userObj instanceof User)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("User not logged in");
            }
            User user = (User) userObj;
            String userName = user.getUsername();  // Use username from the session

            String razorpayOrderId = data.get("order_id").toString();
            String paymentId = data.get("payment_id").toString();
            String status = data.get("status").toString();  
            String userEmail = data.get("userEmail").toString();
         /*   String userPhone = data.get("userPhone").toString();*/
            LocalDateTime bookingDate = LocalDateTime.now();
            int ticketCount = Integer.parseInt(data.get("ticketCount").toString());
            double amount = Double.parseDouble(data.get("amount").toString());
            Long eventId = Long.parseLong(data.get("eventId").toString());

            // Save the order details in the database using the username from the logged in user
            orderService.saveOrder(razorpayOrderId, paymentId, status, userName, userEmail,
                     ticketCount, amount, eventId, bookingDate);

            return ResponseEntity.ok("Payment verified and order saved");
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
