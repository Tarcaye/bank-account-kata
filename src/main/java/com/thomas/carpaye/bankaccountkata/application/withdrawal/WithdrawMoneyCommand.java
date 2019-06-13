package com.thomas.carpaye.bankaccountkata.application.withdrawal;

public class WithdrawMoneyCommand {
    private final String accountId;
    private final int money;

    public WithdrawMoneyCommand(String accountId, int money) {
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
