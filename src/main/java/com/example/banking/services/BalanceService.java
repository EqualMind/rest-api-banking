package com.example.banking.services;

import com.example.banking.entities.Balance;
import com.example.banking.repositories.AccountRepository;
import com.example.banking.repositories.BalanceRepository;
import com.example.banking.values.AddBalanceRequest;
import com.example.banking.values.SendMoneyRequest;
import com.example.banking.values.SubstractBalanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

/** Сервис для работы со счетами пользователей. */
@Service
public class BalanceService {

    /** Валидатор данных. */
    protected final Validator validator;

    /** Репозиторий по работе с аккаунтами пользователей. */
    protected final AccountRepository accounts;

    /** Репозиторий по работе со счетами пользователей. */
    protected final BalanceRepository balances;

    /** Загрузка зависимостей для сервиса по работе со счетами пользователей. */
    public BalanceService(Validator validator, AccountRepository accounts, BalanceRepository balances) {
        this.validator = validator;
        this.accounts = accounts;
        this.balances = balances;
    }

    /** Возвращает список счетов аккаунта пользователя по его идентификатору. */
    public List<Balance> findByAccountId(long id) {
        return accounts.findById(id).getBalances();
    }

    /** Осуществляет обмен денежных средств между счетами. */
    public boolean exchange(@Valid SendMoneyRequest request) throws ConstraintViolationException {
        var balanceFrom = balances.findById(request.getFrom());
        var balanceTo = balances.findById(request.getTo());

        balanceFrom.setAmount(balanceFrom.getAmount().subtract(request.getAmount()));
        balanceTo.setAmount(balanceTo.getAmount().add(request.getAmount()));

        validateBalance(balanceFrom);
        validateBalance(balanceTo);

        balances.save(balanceFrom);
        balances.save(balanceTo);

        return true;
    }

    /** Осуществляет пополнение баланса пользователя. */
    public boolean add(AddBalanceRequest request) throws ConstraintViolationException {
        var balance = balances.findById(request.getId());

        balance.setAmount(balance.getAmount().add(request.getAmount()));
        validateBalance(balance);

        balances.save(balance);

        return true;
    }

    /** Осуществляет снятие денежных средств со счета пользователя. */
    public boolean substract(SubstractBalanceRequest request) throws ConstraintViolationException {
        var balance = balances.findById(request.getId());

        balance.setAmount(balance.getAmount().subtract(request.getAmount()));
        validateBalance(balance);

        balances.save(balance);

        return true;
    }

    /** Осуществляет валидацию счёта пользователя. */
    private void validateBalance(Balance balance) {
        var violations = validator.validate(balance);

        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
