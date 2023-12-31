package com.example.commutitas.repository;

import com.example.commutitas.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.name = ?1")
    Optional<Account> findAccountByName(String name);

    @Query("SELECT a FROM Account a WHERE a.user_name = ?1")
    Optional<Account> findAccountByUserName(String userName);
}
