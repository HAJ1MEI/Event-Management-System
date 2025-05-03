package com.example.event_management_system.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${razorpay.key-id}")
    private String keyId;

    @Value("${razorpay.key-secret}")
    private String keySecret;

    public JSONObject createOrder(int amount) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100);  
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt#1");

        Order order = razorpay.orders.create(orderRequest);
        System.out.println("✅ Order Created: " + order.toString());
        return order.toJson();
    }


}
