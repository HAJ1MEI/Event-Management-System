package com.example.event_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Wishlist() {}

    public Wishlist(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Event getEvent() { return event; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setEvent(Event event) { this.event = event; }
}
