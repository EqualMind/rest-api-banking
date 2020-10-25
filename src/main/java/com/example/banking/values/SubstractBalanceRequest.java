package com.example.banking.values;

import java.math.BigDecimal;

/** Описывает получаемый объект при запросе снятия денежных средств со счета пользователя. */
public class SubstractBalanceRequest {
    protected long id;
    protected BigDecimal amount;

    /** Возвращает идентификатор счёта. */
    public long getId() {
        return id;
    }

    /** Возвращает значение списываемой со счёта суммы. */
    public BigDecimal getAmount() {
        return amount;
    }
}
