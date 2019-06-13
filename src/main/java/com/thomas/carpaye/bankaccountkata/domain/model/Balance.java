package com.thomas.carpaye.bankaccountkata.domain.model;

public class Balance {

    private final int value;

    public Balance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean insufficientFunds(Amount overdraft, Withdrawal withdrawal) {
        int futureBalance = withdrawal.futureBalance(this);
        return futureBalance < overdraft.value;
    }
}
