package com.example.commutitas.repository;

import com.example.commutitas.entity.EventAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventAttendeeRepository
        extends JpaRepository<EventAttendee, Long> {

}
