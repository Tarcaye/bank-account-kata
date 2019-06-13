package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OverdraftRepository;

public class SimpleOverdraftRepository implements OverdraftRepository {
    @Override
    public Amount getOverdraft(Account account) {
        return new Amount(0);
    }
}
