package com.thomas.carpaye.bankaccountkata.application.balance;

public class CheckBalanceQuery {

    private final String accountId;

    public CheckBalanceQuery(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
