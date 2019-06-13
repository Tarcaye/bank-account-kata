package com.thomas.carpaye.bankaccountkata.application;

import com.thomas.carpaye.bankaccountkata.domain.model.*;

public class WithdrawMoney {

    private final CheckBalance checkBalance;
    private final PastTransactionsRepository pastTransactionsRepository;
    private final OverdraftRepository overdraftRepository;

    public WithdrawMoney(CheckBalance checkBalance, PastTransactionsRepository pastTransactionsRepository, OverdraftRepository overdraftRepository) {
        this.checkBalance = checkBalance;
        this.pastTransactionsRepository = pastTransactionsRepository;
        this.overdraftRepository = overdraftRepository;
    }

    public void withdraw(String accountId, int money) {
        final Account account = new Account(accountId);
        Amount overdraft = overdraftRepository.getOverdraft(account);
        Balance accountBalance = checkBalance.getAccountBalance(account);
        Withdrawal withdrawal = Withdrawal.of(money);

        if (accountBalance.insufficientFunds(overdraft, withdrawal)) {
            throw new InsufficientFundsException("Insufficient funds for withdraw : " + withdrawal + " on account : " + account);
        }

        pastTransactionsRepository.add(account, withdrawal);
    }

}
