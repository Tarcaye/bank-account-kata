package com.thomas.carpaye.bankaccountkata.domain.model.common;

import com.thomas.carpaye.bankaccountkata.domain.model.deposit.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.Withdrawal;

public class Balance {

    private final int value;

    public Balance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean insufficientFunds(Amount overdraft) {
        return this.value < overdraft.value;
    }

    public Balance add(Deposit deposit) {
        return new Balance(value + deposit.getAmount());
    }

    public Balance add(Withdrawal withdrawal) {
        return new Balance(value - withdrawal.getAmount());
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
