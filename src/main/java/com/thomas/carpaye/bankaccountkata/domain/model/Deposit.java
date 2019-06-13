package com.thomas.carpaye.bankaccountkata.domain.model;

public class Deposit extends PastTransaction {

    private Deposit(Amount amount) {
        super(amount);
    }

    public static Deposit of(int amount) {
        checkAmount(amount);
        return new Deposit(new Amount(amount));
    }

    private static void checkAmount(int amount) {
        if (amount<=0){
            throw new InvalidDepositAmountException("Invalid amount for deposit : " + amount);
        }
    }

}
