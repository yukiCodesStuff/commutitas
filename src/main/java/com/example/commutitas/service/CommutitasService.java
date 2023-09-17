package com.example.commutitas.service;

import com.example.commutitas.entity.Account;
import com.example.commutitas.entity.Event;
import com.example.commutitas.entity.EventAttendee;
import com.example.commutitas.repository.AccountRepository;
import com.example.commutitas.repository.EventAttendeeRepository;
import com.example.commutitas.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommutitasService {
    private AccountRepository accountRepository;
    private EventRepository eventRepository;
    private EventAttendeeRepository eventAttendeeRepository;

    @Autowired
    public CommutitasService(
            AccountRepository accountRepository,
            EventRepository eventRepository,
            EventAttendeeRepository eventAttendeeRepository
    ) {
        this.accountRepository = accountRepository;
        this.eventRepository = eventRepository;
        this.eventAttendeeRepository = eventAttendeeRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void addNewAccount(Account account) {
//        Optional<Account> accountByName = accountRepository
//                .findAccountByName(account.getName());
//
//        if (accountByName.isPresent()) {
//            throw new IllegalStateException("name taken");
//        }

        Optional<Account> accountByUserName = accountRepository
                .findAccountByUserName(account.getUserName());

        if (accountByUserName.isPresent()) {
            throw new IllegalStateException("Username is already taken");
        }

        accountRepository.save(account);
    }

    public void addNewEvent(
            String userName,
            Event event)
    {
        Optional<Event> eventByName = eventRepository
                .findEventByName(event.getName());

        Optional<Account> accountByUserName = accountRepository.findAccountByUserName(userName);

        if (accountByUserName.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist!");
        }

        if (eventByName.isPresent() && eventByName.get().getHostName().equals(userName)) {
            throw new IllegalStateException("Event name already taken!");
        }

        System.out.println(event);

        eventRepository.save(event);
    }

    public void deleteAccount(Long id) {
        boolean exists = accountRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "account with id " + id + " does not exist");
        }

        accountRepository.deleteById(id);
    }

    public void deleteEvent(String userName, String eventName) {
        Optional<Account> accountByUserName = accountRepository.findAccountByUserName(userName);

        if (accountByUserName.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        Optional<Event> eventByName = eventRepository.findEventByNameAndHostName(eventName, userName);

        if (eventByName.isEmpty()) {
            throw new IllegalStateException("The event " + eventName + " hosted by user " + userName + " does not exist");
        }

        eventRepository.deleteById(eventByName.get().getId());
    }

    public void registerForEvent(
            String userName,
            String eventName,
            String hostName
    ) {

        Optional<Account> accountByUsername = accountRepository.findAccountByUserName(userName);
        if (accountByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        Optional<Event> eventByEventNameAndHostName = eventRepository
                .findEventByNameAndHostName(eventName, hostName);
        if (eventByEventNameAndHostName.isEmpty()) {
            throw new IllegalStateException(
                    "The event " + eventName + " hosted by " + hostName + " does not exist"
            );
        }

        Account attendee = accountByUsername.get();
        Event event = eventByEventNameAndHostName.get();

        List<Account> copyThing = event.getAttendees();
        copyThing.add(attendee);

        event.setAttendees(copyThing);

        // Save the event and flush changes to the database
        eventRepository.saveAndFlush(event);
    }

    public void withdrawFromEvent(
            String userName,
            String eventName,
            String hostName
    ) {
        Optional<Account> accountByUsername = accountRepository.findAccountByUserName(userName);
        if (accountByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        Optional<Event> eventByEventNameAndHostName = eventRepository
                .findEventByNameAndHostName(eventName, hostName);
        if (eventByEventNameAndHostName.isEmpty()) {
            throw new IllegalStateException(
                    "The event " + eventName + " hosted by " + hostName + " does not exist"
            );
        }

        Account attendee = accountByUsername.get();
        Event event = eventByEventNameAndHostName.get();

        List<Account> copyThing = event.getAttendees();
        copyThing.remove(attendee);

        event.setAttendees(copyThing);

        // Save the event and flush changes to the database
        eventRepository.saveAndFlush(event);
    }

}
