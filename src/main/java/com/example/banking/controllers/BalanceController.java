package com.example.banking.controllers;

import com.example.banking.entities.Balance;
import com.example.banking.values.AddBalanceRequest;
import com.example.banking.values.SendMoneyRequest;
import com.example.banking.services.BalanceService;
import com.example.banking.values.SubstractBalanceRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Контроллер, описывающий работу со счетами пользователей
 */
@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    /** Сервис для работы со счетами пользователей */
    protected final BalanceService balance;

    /** Подгрузка зависимостей */
    public BalanceController(BalanceService balance) {
        this.balance = balance;
    }

    @GetMapping("/{account_id}")
    @ApiOperation("Возвращает информацию о счетах аккаунта пользователя")
    public List<Balance> findByAccountId(@PathParam("account_id") long id) {
        return balance.findByAccountId(id);
    }

    @PatchMapping("/send")
    @ApiOperation("Осуществляет перевод денег между счетами")
    public boolean exchange(@RequestBody SendMoneyRequest input) {
        return balance.exchange(input);
    }

    @PatchMapping("/add")
    @ApiOperation("Добавляет деньги на счет")
    public boolean add(@RequestBody AddBalanceRequest input) {
        return balance.add(input);
    }

    @PatchMapping("/substract")
    @ApiOperation("Снимает деньги со счёта")
    public boolean substract(@RequestBody SubstractBalanceRequest input) {
        return balance.substract(input);
    }

}
