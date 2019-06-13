package com.thomas.carpaye.bankaccountkata.domain.model.withdrawal;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.InvalidDepositAmountException;

public class Withdrawal {

    private final Amount amount;

    private Withdrawal(Amount amount) {
        this.amount = amount;
    }

    public static Withdrawal of(Amount amount) {
        checkAmount(amount);
        return new Withdrawal(amount);
    }

    private static void checkAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new InvalidDepositAmountException("Invalid amount for withdrawal : " + amount);
        }
    }

    public int getAmount() {
        return amount.getValue();
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "amount=" + amount +
                '}';
    }
}
