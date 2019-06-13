package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.OverdraftRepository;

public class SimpleOverdraftRepository implements OverdraftRepository {
    @Override
    public Amount getOverdraft(Account account) {
        return new Amount(0);
    }
}
