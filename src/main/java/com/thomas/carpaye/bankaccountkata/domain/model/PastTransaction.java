package com.thomas.carpaye.bankaccountkata.domain.model;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;

import java.time.LocalDateTime;

public abstract class PastTransaction {

    final Amount amount;
    final LocalDateTime date;

    PastTransaction(Amount amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
