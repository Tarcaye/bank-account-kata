package com.thomas.carpaye.bankaccountkata.application.deposit;

public class SaveMoneyCommand {
    private final String accountId;
    private final int money;

    public SaveMoneyCommand(String accountId, int money) {
        this.accountId = accountId;
        this.money = money;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getMoney() {
        return money;
    }
}
