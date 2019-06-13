package com.thomas.carpaye.bankaccountkata.domain.model.withdrawal;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;

public interface OverdraftRepository {
    Amount getOverdraft(Account account);
}
