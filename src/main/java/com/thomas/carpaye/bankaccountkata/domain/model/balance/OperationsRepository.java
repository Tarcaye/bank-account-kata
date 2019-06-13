package com.thomas.carpaye.bankaccountkata.domain.model.balance;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;

public interface OperationsRepository {
    Balance getBalance(Account account);
}
