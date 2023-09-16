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

    @GetMapping(value = "/events")
    public List<Event> getEvents() {
        return commutitasService.getEvents();
    }

    @PostMapping
    public void registerNewAccount(
            @RequestBody Account account) {
        commutitasService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(
            @PathVariable("accountId") Long id) {
        commutitasService.deleteAccount(id);
    }
}
