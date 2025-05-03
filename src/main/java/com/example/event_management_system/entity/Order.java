package com.example.event_management_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorpayOrderId;
    private String paymentId;
    private String status;
    private String userName;  
    private String userEmail;
    private int ticketCount;
    private double amount;
    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Order() {}

    public Order(String razorpayOrderId, String paymentId, String status, String userName, String userEmail,
                  int ticketCount, double amount, LocalDateTime bookingDate, Event event) {
        this.razorpayOrderId = razorpayOrderId;
        this.paymentId = paymentId;
        this.status = status;
        this.userName = userName;
        this.ticketCount = ticketCount;
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.event = event;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

    
}
