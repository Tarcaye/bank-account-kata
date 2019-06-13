package com.thomas.carpaye.bankaccountkata.domain.model;

public class Withdrawal extends PastTransaction {

    private Withdrawal(Account account, Amount amount) {
        super(account, amount);
    }

    public static Withdrawal of(String accountId, int amount) {
        checkAmount(amount);
        return new Withdrawal(new Account(accountId), new Amount(amount));
    }

    private static void checkAmount(int amount) {
        if (amount<=0){
            throw new InvalidDepositAmountException("Invalid amount for withdrawal : " + amount);
        }
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "account=" + account +
                ", amount=" + amount +
                '}';
    }

    public int futureBalance(Balance balance) {
        return balance.getValue() - amount.value;
    }
}
