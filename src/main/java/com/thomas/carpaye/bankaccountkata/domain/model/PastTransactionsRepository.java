package com.thomas.carpaye.bankaccountkata.domain.model;

public interface PastTransactionsRepository {
    void add(Account account, Deposit deposit);

    void add(Account account, Withdrawal withdrawal);

    Amounts getDepositAmounts(Account account);

    Amounts getWithdrawalAmounts(Account account);
}
