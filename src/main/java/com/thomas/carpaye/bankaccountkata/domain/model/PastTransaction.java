package com.thomas.carpaye.bankaccountkata.domain.model;

import java.time.LocalDateTime;

public abstract class PastTransaction {

    final Account account;
    final Amount amount;

    PastTransaction(Account account, Amount amount) {
        this.account = account;
        this.amount = amount;
    }

    private static void checkAmount(int amount) {
        if (amount<=0){
            throw new InvalidDepositAmountException("Invalid amount for deposit : " + amount);
        }
    }

    public Amount getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

}
