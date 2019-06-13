package com.thomas.carpaye.bankaccountkata.domain.model;

import java.time.LocalDateTime;

public abstract class PastTransaction {

    final Amount amount;
    final LocalDateTime date;

    PastTransaction(Amount amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    private static void checkAmount(int amount) {
        if (amount <= 0) {
            throw new InvalidDepositAmountException("Invalid amount for deposit : " + amount);
        }
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
