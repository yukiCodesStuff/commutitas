package com.example.commutitas.repository;

import com.example.commutitas.entity.Event;
import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository
        extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.name = ?1")
    Optional<Event> findEventByName(String name);

    @Query("SELECT e from Event e where e.name = ?1")
    List<Event> findEventsByName(String name);

    @Query("SELECT e FROM Event e WHERE e.hostName = ?1")
    List<Event> findEventsByHostName(String hostName);

    @Query("SELECT e FROM Event e WHERE e.name = ?1 AND e.hostName = ?2")
    Optional<Event> findEventByNameAndHostName(String name, String hostName);

    @Query("SELECT e FROM Event e WHERE e.religion = ?1")
    List<Event> findEventByReligion(Religion religion);

    @Query("SELECT e FROM Event e WHERE e.location = ?1")
    List<Event> findEventsByLocation(Location location);

    @Query("SELECT e FROM Event e WHERE e.date = ?1")
    List<Event> findEventsByDate(String date);
}
