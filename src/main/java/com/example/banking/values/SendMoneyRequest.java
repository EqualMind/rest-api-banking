package com.example.banking.values;

import java.math.BigDecimal;

/** Представляет объект получаемый при запросе передачи денег между счетами. */
public class SendMoneyRequest {
    protected long from;
    protected long to;
    protected BigDecimal amount;

    /** Возвращает идентификатор счёта, с которого будут списаны денежные средства. */
    public long getFrom() {
        return from;
    }

    /** Возвращает идентификатор счёта, на который будут зачислены денежные средства. */
    public long getTo() {
        return to;
    }

    /** Возвращает сумму, перечисляемую между счетами. */
    public BigDecimal getAmount() {
        return amount;
    }
}
