package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.*;

import java.util.*;

public class InMemoryDepositRepository implements DepositRepository {

    private Map<Account, List<Amount>> depositByAccount = new HashMap<>();

    @Override
    public void add(Deposit deposit) {
        List<Amount> amounts = getAmounts(deposit.getAccount());
        amounts.add(deposit.getAmount());
        depositByAccount.put(deposit.getAccount(), amounts);
    }

    private List<Amount> getAmounts(Account account) {
        List<Amount> amounts = depositByAccount.get(account);
        if (amounts == null){
            amounts = new ArrayList<>();
        }
        return amounts;
    }

    @Override
    public Amounts getDepositAmounts(Account account) {
        return Amounts.of(depositByAccount.get(account));
    }
}
