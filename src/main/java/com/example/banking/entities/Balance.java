package com.example.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Описывает сущность счета пользователя.
 */
@Entity
public class Balance {

    /** Идентификатор счета. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** Остаток на балансе. */
    @DecimalMin(value = "0.0", message = "баланс аккаунта не может быть меньше 0.0")
    private BigDecimal amount;

    /** Ссылка на аккаунт, которому принадлежит счёт. */
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;

    protected Balance() {

    }

    /** Создание нового счёта. */
    public Balance(Account account, BigDecimal amount) {
        this.amount = amount;
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format("Balance [%d]: %s", id, amount);
    }

    /** Возвращает идентификатор счёта. */
    public long getId() {
        return id;
    }

    /** Возвращает остаток на балансе счёта. */
    public BigDecimal getAmount() {
        return amount;
    }

    /** Устанавливает новое значение остатка на балансе счёта. */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
