package com.example.event_management_system.service;

import com.example.event_management_system.entity.Event;
import com.example.event_management_system.entity.Order;
import com.example.event_management_system.repository.EventRepository;
import com.example.event_management_system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void saveOrder(String razorpayOrderId, String paymentId, String status, 
                          String userName, String userEmail,  
                          int ticketCount, double amount, Long eventId, LocalDateTime bookingDate) {
        // Fetch the event; if not found, an exception is thrown and transaction rolled back.
        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found"));

        // You can choose to use the passed bookingDate or LocalDateTime.now()
        Order order = new Order(razorpayOrderId, paymentId, status, userName, userEmail,
                                   ticketCount, amount, LocalDateTime.now(), event);
        orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String userName) { 
        return orderRepository.findByUserName(userName);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
