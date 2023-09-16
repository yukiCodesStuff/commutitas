package com.example.commutitas.service;

import com.example.commutitas.entity.Account;
import com.example.commutitas.entity.Event;
import com.example.commutitas.enums.AccountType;
import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import com.example.commutitas.repository.AccountRepository;
import com.example.commutitas.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.commutitas.enums.DietaryRestrictions.PEANUT_BUTTER;
import static com.example.commutitas.enums.DietaryRestrictions.SHELLFISH;

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
        Optional<Account> accountByName = accountRepository
                .findAccountByName(account.getName());

        if (accountByName.isPresent()) {
            throw new IllegalStateException("name taken");
        }

        accountRepository.save(account);
    }

    public void addNewEvent(
            Account account,
            Event event)
    {
        Optional<Event> eventByName = eventRepository
                .findEventByName(event.getName());

        String accountName = account.getName();
        if (eventByName.isPresent() && eventByName.get().getHostName().equals(accountName)) {
            throw new IllegalStateException("Event name already taken!");
        }

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
}
