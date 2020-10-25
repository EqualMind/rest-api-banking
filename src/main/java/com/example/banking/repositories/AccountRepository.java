package com.example.banking.repositories;

import com.example.banking.entities.Account;
import org.springframework.data.repository.CrudRepository;

/** Описывает CRUD репозиторий для работы с сущностями аккаунтов пользователей. */
public interface AccountRepository extends CrudRepository<Account, Long> {
    /** Возвращает аккаунт пользователя по идентификатору */
    Account findById(long id);
}
