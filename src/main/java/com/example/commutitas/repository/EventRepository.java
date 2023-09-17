package com.example.commutitas.repository;

import com.example.commutitas.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository
        extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.name = ?1")
    Optional<Event> findEventByName(String name);

    @Query("SELECT e FROM Event e WHERE e.hostName = ?1")
    List<Event> findEventsByHostName(String hostName);

    @Query("SELECT e FROM Event e WHERE e.name = ?1 AND e.hostName = ?2")
    Optional<Event> findEventByNameAndHostName(String name, String hostName);
}
