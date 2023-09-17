package com.example.commutitas.controller;

import com.example.commutitas.entity.Account;
import com.example.commutitas.entity.Event;
import com.example.commutitas.service.CommutitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commutitas")
public class CommutitasController {

    private final CommutitasService commutitasService;

    @Autowired
    public CommutitasController(CommutitasService commutitasService) {
        this.commutitasService = commutitasService;
    }

    @GetMapping(value = "/users")
    public List<Account> getAccounts() {
        return commutitasService.getAccounts();
    }

    @GetMapping(value = "/event")
    public List<Event> getEvents() {
        return commutitasService.getEvents();
    }

    @PostMapping
    public void registerNewAccount(
            @RequestBody Account account) {
        commutitasService.addNewAccount(account);
    }

    @PostMapping(value = "/event/{accountName}/create")
    public void createNewEvent(
            @PathVariable("accountName") String accountName,
            @RequestBody Event event
    ) {
        commutitasService.addNewEvent(accountName, event);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(
            @PathVariable("accountId") Long id) {
        commutitasService.deleteAccount(id);
    }

    @DeleteMapping(path = "/event/delete/{eventName}/{userName}")
    public void deleteEvent(
            @PathVariable("eventName") String eventName,
            @PathVariable("userName") String userName
    ) {
        commutitasService.deleteEvent(userName, eventName);
    }

    @PutMapping(value = "/{userName}/register/{eventName}/{hostName}")
    public void registerForEvent(
            @PathVariable("userName") String userName,
            @PathVariable("eventName") String eventName,
            @PathVariable("hostName") String hostName
    ) {
        commutitasService.registerForEvent(userName, eventName, hostName);
    }

    @PutMapping(value = "/{userName}/withdraw/{eventName}/{hostName}")
    public void withdrawEvent(
            @PathVariable("userName") String userName,
            @PathVariable("eventName") String eventName,
            @PathVariable("hostName") String hostName
    ) {
        commutitasService.withdrawFromEvent(userName, eventName, hostName);
    }
}
