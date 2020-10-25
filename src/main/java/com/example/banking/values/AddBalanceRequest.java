package com.example.banking.values;

import java.math.BigDecimal;

/** Представляет объект, получаемый при запросе на пополнение остатка на счете пользователя. */
public class AddBalanceRequest {
    protected long id;
    protected BigDecimal amount;

    /** Возвращает идентификатор счёта для пополнения. */
    public long getId() {
        return id;
    }

    /** Возвращает значение добавляемой суммы на счёт пользователя. */
    public BigDecimal getAmount() {
        return amount;
    }
}
