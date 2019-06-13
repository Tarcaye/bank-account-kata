package com.thomas.carpaye.bankaccountkata.domain.model.history;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;

public interface OperationsRepository {
    History getHistory(Account account);
}
