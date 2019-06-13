package com.thomas.carpaye.bankaccountkata.infrastructure.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private final int amount;
    private final int balance;
    private final LocalDate date;

    private Transaction(Builder builder) {
        this.date = LocalDate.now();
        this.amount = builder.amount;
        this.balance = builder.balance;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }

    public static class Builder {
        private int amount;
        private int balance;

        public Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder withBalance(int balance) {
            this.balance = balance;
            return this;
        }

        public Transaction build(){
            return new Transaction(this);
        }
    }
}
