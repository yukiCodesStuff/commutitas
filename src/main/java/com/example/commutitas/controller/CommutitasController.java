package com.example.commutitas.controller;

import com.example.commutitas.entity.Account;
import com.example.commutitas.service.CommutitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commutitas/users/")
public class CommutitasController {

    private final CommutitasService commutitasService;

    @Autowired
    public CommutitasController(CommutitasService commutitasService) {
        this.commutitasService = commutitasService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return commutitasService.getAccounts();
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
