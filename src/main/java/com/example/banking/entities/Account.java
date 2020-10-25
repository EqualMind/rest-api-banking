package com.example.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Описывает сущность аккаунта пользователя
 */
@Entity
public class Account {

    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Имя пользователя
     */
    @NotBlank
    private String name;

    /**
     * Реализация связи один-ко-многим со счетами пользователей. У каждого аккаунта может быть несколько счетов.
     */
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Balance> balances = new ArrayList<Balance>();

    protected Account() {
    }

    /**
     * Создание нового аккаунта.
     * @param name
     */
    public Account(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Account [%d]: '%s'", id, name);
    }

    /**
     * Возвращает идентификатор пользователя
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Возвращает имя пользователя
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает список объектов, представляющих счета пользователя.
     * @return
     */
    public List<Balance> getBalances() {
        return balances;
    }
}
