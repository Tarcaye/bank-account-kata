package com.thomas.carpaye.bankaccountkata.application.history;

public class SeeHistoryQuery {
    private final String accountId;

    public SeeHistoryQuery(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
