package com.thomas.carpaye.bankaccountkata.domain.model.deposit;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;

public interface OperationsRepository {
    void add(Account account, Deposit of);
}
