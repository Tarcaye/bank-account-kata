package com.thomas.carpaye.bankaccountkata.domain.model;

import java.util.Objects;

public class Account {

    public static final String ACCOUNT_ID_REGEX = "[0-9]+";

    private final String accountId;

    public Account(String accountId) {
        this.accountId = accountId;
    }
    public static Account of(String accountId) {
        checkAccountId(accountId);
        return new Account(accountId);
    }

    private static void checkAccountId(String accountId) {
        if (accountId==null || accountId.matches(ACCOUNT_ID_REGEX)){
            throw new InvalidAccountException("Invalid accountId : " + accountId);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId.equals(account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                '}';
    }
}
