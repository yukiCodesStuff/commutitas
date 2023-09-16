package com.example.commutitas.service;

import com.example.commutitas.entity.Account;
import com.example.commutitas.enums.AccountType;
import com.example.commutitas.enums.Location;
import com.example.commutitas.enums.Religion;
import com.example.commutitas.repository.CommutitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.commutitas.enums.DietaryRestrictions.PEANUT_BUTTER;
import static com.example.commutitas.enums.DietaryRestrictions.SHELLFISH;

@Service
public class CommutitasService {
    private CommutitasRepository commutitasRepository;

    @Autowired
    public CommutitasService(CommutitasRepository commutitasRepository) {
        this.commutitasRepository = commutitasRepository;
    }

    public List<Account> getAccounts() {
        return commutitasRepository.findAll();
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountByName = commutitasRepository
                .findAccountByName(account.getName());

        if (accountByName.isPresent()) {
            throw new IllegalStateException("name taken");
        }

        commutitasRepository.save(account);
    }

    public void deleteAccount(Long id) {
        boolean exists = commutitasRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "account with id " + id + " does not exist");
        }

        commutitasRepository.deleteById(id);
    }

    public List<Account> getAccountsTest() {
        return List.of(
                new Account(
                        Long.valueOf(1),
                        Location.TX,
                        "000-000-0000",
                        "jane.doe@email.com",
                        "Jane Doe",
                        AccountType.GUEST,
                        List.of(
                                SHELLFISH,
                                PEANUT_BUTTER
                        ),
                        Religion.CHRISTIANITY,
                        23,
//                        LocalDate.of(2000, 1, 1),
                        "I love to hack!"
                )
        );
    }
}
