package com.thomas.carpaye.bankaccountkata.domain.model;

public class Deposit extends PastTransaction {

    private Deposit(Account account, Amount amount) {
        super(account, amount);
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

}
