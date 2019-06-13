package com.thomas.carpaye.bankaccountkata.domain.model;

public class Deposit {

    private final Account account;
    private final Amount amount;

    private Deposit(Account account, Amount amount) {
        this.account = account;
        this.amount = amount;
    }

    public static Deposit of(String accountId, int amount) {
        checkAmount(amount);
        return new Deposit(new Account(accountId), new Amount(amount));
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
