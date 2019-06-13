package com.thomas.carpaye.bankaccountkata.domain.model;

public class Withdrawal extends PastTransaction {

    private Withdrawal(Amount amount) {
        super(amount);
    }

    public static Withdrawal of(int amount) {
        checkAmount(amount);
        return new Withdrawal(new Amount(amount));
    }

    private static void checkAmount(int amount) {
        if (amount<=0){
            throw new InvalidDepositAmountException("Invalid amount for withdrawal : " + amount);
        }
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                ", amount=" + amount +
                '}';
    }

    public int futureBalance(Balance balance) {
        return balance.getValue() - amount.value;
    }
}
