package com.example.commutitas.entity;

import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Event {

    private String name;
    private String userName;
    private String hostName;
    private Religion religion;
    private Integer maxCapacity;
    private String date;
    private String time;
    private String city;
    private Location location;
    private String description;
    private Integer ageLimit;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private List<Account> attendees;


    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long id;

    public Event(
            String name,
            String userName,
            String hostName,
            Religion religion,
            Integer maxCapacity,
            String date,
            String time,
            String city,
            Location location,
            String description,
            Integer ageLimit,
            List<Account> attendees) {
        this.name = name;
        this.userName = userName;
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
    }

    public Event(
            String name,
            String userName,
            String hostName,
            Religion religion,
            Integer maxCapacity,
            String date,
            String time,
            String city,
            Location location,
            String description,
            Integer ageLimit,
            List<Account> attendees,
            Long id) {
        this.name = name;
        this.userName = userName;
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

    public Event() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public List<Account> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Account> attendees) {
        this.attendees = attendees;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", religion=" + religion +
                ", maxCapacity=" + maxCapacity +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", city='" + city + '\'' +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", ageLimit=" + ageLimit +
                ", attendees=" + attendees +
                ", id=" + id +
                '}';
    }
}
