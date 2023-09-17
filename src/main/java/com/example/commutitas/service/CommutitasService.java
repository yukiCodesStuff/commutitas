package com.example.commutitas.service;

import com.example.commutitas.entity.Account;
import com.example.commutitas.entity.Event;
import com.example.commutitas.enums.AccountType;
import com.example.commutitas.repository.AccountRepository;
import com.example.commutitas.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivilegedActionException;
import java.util.List;
import java.util.Optional;


@Service
public class CommutitasService {
    private AccountRepository accountRepository;
    private EventRepository eventRepository;

    @Autowired
    public CommutitasService(
            AccountRepository accountRepository,
            EventRepository eventRepository
    ) {
        this.accountRepository = accountRepository;
        this.eventRepository = eventRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void addNewAccount(Account account) {

        Optional<Account> accountByUserName = accountRepository
                .findAccountByUserName(account.getUserName());

        if (accountByUserName.isPresent()) {
            throw new IllegalStateException("Username "
                    + account.getUserName() + " is already taken");
        }

        accountRepository.save(account);
    }

    public void checkEachUser(List<Account> accounts) {
        for (Account account : accounts) {
            addNewAccount(account);
            Optional<Account> accountByUserName = accountRepository
                .findAccountByUserName(account.getUserName());

            if (accountByUserName.isPresent()) {
                return;
        }

        accountRepository.save(account);
        }
    }

    public void addNewEvent(
            String userName,
            Event event)
    {
        Optional<Event> eventByNameAndHostName = eventRepository
                .findEventByNameAndHostName(event.getName(), event.getHostName());

        Optional<Account> accountByUserName = accountRepository.findAccountByUserName(userName);

        if (accountByUserName.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist!");
        }

        if (eventByNameAndHostName.isPresent()) {
            throw new IllegalStateException("This event already exists");
        }

        System.out.println(event);

        eventRepository.save(event);
    }

    public void deleteAccount(Long id) {

        // Check if user id exists
        boolean exists = accountRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "account with id " + id + " does not exist");
        }

        // Delete
        accountRepository.deleteById(id);
    }

    public void deleteAccountByUsername(String userName) {

        // Check to see if user exists
        Optional<Account> userByUsername = accountRepository.findAccountByUserName(userName);
        if (userByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        // Get user id
        Long idToDelete = userByUsername.get().getId();

        // Delete user
        accountRepository.deleteById(idToDelete);
    }

    public void deleteEvent(String userName, String eventName) {

        // Check if user exists
        Optional<Account> accountByUserName = accountRepository.findAccountByUserName(userName);
        if (accountByUserName.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        // Check if event exists
        Optional<Event> eventByName = eventRepository.findEventByNameAndHostName(eventName, userName);
        if (eventByName.isEmpty()) {
            throw new IllegalStateException("The event " + eventName + " hosted by user " + userName + " does not exist");
        }

        Account account = accountByUserName.get();
        Event event = eventByName.get();

        // Only host is allowed to delete the event
        if (!event.getUserName().equals(account.getUserName())) {
            throw new IllegalStateException("You are not allowed to perform this action!");
        }

        eventRepository.deleteById(eventByName.get().getId());
    }

    public void registerForEvent(
            String userName,
            String eventName,
            String hostName
    ) {

        // Ensure user is valid
        Optional<Account> accountByUsername = accountRepository.findAccountByUserName(userName);
        if (accountByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        // Ensure event is valid
        Optional<Event> eventByEventNameAndHostName = eventRepository
                .findEventByNameAndHostName(eventName, hostName);
        if (eventByEventNameAndHostName.isEmpty()) {
            throw new IllegalStateException(
                    "The event " + eventName + " hosted by " + hostName + " does not exist"
            );
        }

        // Check to see if user is allowed to attend event
        Account attendee = accountByUsername.get();
        Event event = eventByEventNameAndHostName.get();

        if (attendee.getAge() < event.getAgeLimit()) {
            throw new IllegalStateException("You are too young to attend this event!");
        } else if (event.getHeadCount() >= event.getMaxCapacity()) {
            throw new IllegalStateException("This party is full");
        } else if (event.getAttendees().contains(attendee)) {
            throw new IllegalStateException("You are already attending this event");
        }

        // Add user to the attendee list
        List<Account> copyOfAttendeeList = event.getAttendees();
        copyOfAttendeeList.add(attendee);

        event.setAttendees(copyOfAttendeeList);

        // Save the event and flush changes to the database
        eventRepository.saveAndFlush(event);
    }

    public void withdrawFromEvent(
            String userName,
            String eventName,
            String hostName
    ) {

        // Check if user exists
        Optional<Account> accountByUsername = accountRepository.findAccountByUserName(userName);
        if (accountByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        // Check if event exists
        Optional<Event> eventByEventNameAndHostName = eventRepository
                .findEventByNameAndHostName(eventName, hostName);
        if (eventByEventNameAndHostName.isEmpty()) {
            throw new IllegalStateException(
                    "The event " + eventName + " hosted by " + hostName + " does not exist"
            );
        }

        // Remove user from event
        Account attendee = accountByUsername.get();
        Event event = eventByEventNameAndHostName.get();

        List<Account> copyThing = event.getAttendees();
        copyThing.remove(attendee);

        event.setAttendees(copyThing);

        // Save the event and flush changes to the database
        eventRepository.saveAndFlush(event);
    }

    public Boolean checkIfUserIsHost(String userName) {

        // Check if user exists
        Optional<Account> accountByUsername = accountRepository.findAccountByUserName(userName);
        if (accountByUsername.isEmpty()) {
            throw new IllegalStateException("The user " + userName + " does not exist");
        }

        // Check user Account Type
        Account testAccount = accountByUsername.get();
        return testAccount.getAccountType().equals(AccountType.HOST);
    }

}
