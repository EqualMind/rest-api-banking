package com.example.banking.repositories;

import com.example.banking.entities.Account;
import com.example.banking.entities.Balance;
import org.springframework.data.repository.CrudRepository;

/** Описывает CRUD репозиторий для работы с сущностями счетов аккаунтов пользователей. */
public interface BalanceRepository extends CrudRepository<Balance, Long> {
    /** Возвращает счёт аккаунта для указанного аккаунта. */
    Balance findByAccount(Account account);
    /** Возвращает счёт аккаунта по идентификатору. */
    Balance findById(long id);
}
