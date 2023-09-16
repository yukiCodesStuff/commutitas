package com.example.commutitas.entity;

import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Event {

    private String name;
    private String hostName;
    private Religion religion;
    private Integer maxCapacity;
    private String date;
    private String time;
    private String city;
    private Location location;
    private String description;
    private Integer ageLimit;
    @OneToMany(mappedBy = "event")
    private List<EventAttendee> attendees;
    @Id
    private Long id;

    public Event() {
    }

    public Event(
            String name,
            String hostName,
            Religion religion,
            Integer maxCapacity,
            String date,
            String time,
            String city,
            Location location,
            String description,
            Integer ageLimit,
            List<EventAttendee> attendees,
            Long id) {
        this.name = name;
        this.hostName = hostName;
        this.religion = religion;
        this.maxCapacity = maxCapacity;
        this.date = date;
        this.time = time;
        this.city = city;
        this.location = location;
        this.description = description;
        this.ageLimit = ageLimit;
        this.attendees = attendees;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
