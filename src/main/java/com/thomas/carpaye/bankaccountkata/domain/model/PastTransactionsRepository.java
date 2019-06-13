package com.thomas.carpaye.bankaccountkata.domain.model;

public interface PastTransactionsRepository {
    void add(Deposit deposit);

    void add(Withdrawal withdrawal);

    Amounts getDepositAmounts(Account account);

    Amounts getWithdrawalAmounts(Account account);
}
