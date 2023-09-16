package com.example.commutitas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EventAttendee {

    @Id
    private Long id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Account account;

    public EventAttendee(Long id, Event event, Account account) {
        this.id = id;
        this.event = event;
        this.account = account;
    }

    public EventAttendee() {

    }
}
