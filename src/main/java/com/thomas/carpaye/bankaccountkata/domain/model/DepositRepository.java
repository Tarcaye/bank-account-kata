package com.thomas.carpaye.bankaccountkata.domain.model;

import java.util.List;

public interface DepositRepository {
    void add(Deposit deposit);

    List<Deposit> getDeposits(Account account);
}
