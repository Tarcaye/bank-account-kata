package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.DepositRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDepositRepository implements DepositRepository {

    private Map<Account, List<Amount>> depositByAccount = new HashMap<>();

    @Override
    public void add(Deposit deposit) {
        List<Amount> amounts = depositByAccount.get(deposit.getAccount());
        if (amounts == null){
            amounts = new ArrayList<>();
        }
        amounts.add(deposit.getAmount());
        depositByAccount.put(deposit.getAccount(), amounts);
    }

    @Override
    public List<Deposit> getDeposits(Account account) {
        return null;
    }
}
