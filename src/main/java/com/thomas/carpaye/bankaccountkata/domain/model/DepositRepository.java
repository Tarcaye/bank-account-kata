package com.thomas.carpaye.bankaccountkata.domain.model;

public interface DepositRepository {
    void add(Deposit deposit);

    Amounts getDepositAmounts(Account account);
}
