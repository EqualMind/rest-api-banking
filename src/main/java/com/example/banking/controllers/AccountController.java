package com.example.banking.controllers;

import com.example.banking.entities.Account;
import com.example.banking.repositories.AccountRepository;
import com.example.banking.repositories.BalanceRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Контроллер описывающий работу с аккаунтами
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    /** Репозиторий для работы с аккаунтами пользователей */
    protected final AccountRepository accounts;

    /** Получение зависимостей через конструктор */
    public AccountController(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @GetMapping("/all")
    @ApiOperation("Возвращает информацию о всех пользователях и их счетах")
    public ArrayList<Account> getAllAccounts() {
        return (ArrayList<Account>) accounts.findAll();
    }

}
