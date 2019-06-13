package com.thomas.carpaye.bankaccountkata.domain.model.withdrawal;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;

public interface OperationsRepository {

    void add(Account account, Withdrawal withdrawal);

    Balance getBalance(Account account);
}
