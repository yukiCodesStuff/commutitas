package com.example.commutitas.entity;

import jakarta.persistence.*;

@Entity
public class EventAttendee {

    @Id
    @SequenceGenerator(
            name = "attendee_sequence",
            sequenceName = "attendee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attendee_sequence"
    )
    private Long id;

//    @ManyTo
//    private Event event;

    @ManyToOne
    private Account account;

    public EventAttendee(
            Long id,
//            Event event,
            Account account
    ) {
        this.id = id;
//        this.event = event;
        this.account = account;
    }

    public EventAttendee(
//            Event event,
            Account account
    ) {
//        this.event = event;
        this.account = account;
    }

    public EventAttendee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "EventAttendee{" +
                "id=" + id +
//                ", event=" + event.getName() +
                ", account=" + account +
                '}';
    }
}
