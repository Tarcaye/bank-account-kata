package com.thomas.carpaye.bankaccountkata.domain.model.deposit;

import com.thomas.carpaye.bankaccountkata.domain.model.common.InvalidDepositAmountException;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;

public class Deposit {

    private final Amount amount;

    private Deposit(Amount amount) {
        this.amount = amount;
    }

    public static Deposit of(Amount amount) {
        checkAmount(amount);
        return new Deposit(amount);
    }

    private static void checkAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new InvalidDepositAmountException("Invalid amount for deposit : " + amount);
        }
    }

    public int getAmount() {
        return amount.getValue();
    }
}
