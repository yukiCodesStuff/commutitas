package com.example.commutitas.repository;

import com.example.commutitas.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EventRepository
        extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.name = ?1")
    Optional<Event> findEventByName(String name);
}
