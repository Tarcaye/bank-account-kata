package com.thomas.carpaye.bankaccountkata.domain.model.history;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;

import java.time.LocalDate;

public class Operation {

    private final Type type;
    private final Balance balance;
    private Amount amount;
    private LocalDate date;

    Operation(Type type, Amount amount, LocalDate date, Balance balance) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public static Operation createDeposit(Amount amount, LocalDate date, Balance balance) {
        return new Operation(Type.DEPOSIT, amount, date, balance);
    }

    public static Operation createWithdrawal(Amount amount, LocalDate date, Balance balance) {
        return new Operation(Type.WITHDRAWAL, amount, date, balance);
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return
                type +
                        " | " + date +
                        " | " + amount +
                        " | " + balance;
    }

    public enum Type {
        DEPOSIT, WITHDRAWAL
    }
}
