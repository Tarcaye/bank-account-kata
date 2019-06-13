package com.thomas.carpaye.bankaccountkata.infrastructure;

import com.thomas.carpaye.bankaccountkata.domain.model.common.Account;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Amount;
import com.thomas.carpaye.bankaccountkata.domain.model.common.Balance;
import com.thomas.carpaye.bankaccountkata.domain.model.deposit.Deposit;
import com.thomas.carpaye.bankaccountkata.domain.model.history.History;
import com.thomas.carpaye.bankaccountkata.domain.model.history.Operation;
import com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.Withdrawal;
import com.thomas.carpaye.bankaccountkata.infrastructure.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryOperationsRepository implements com.thomas.carpaye.bankaccountkata.domain.model.withdrawal.OperationsRepository, com.thomas.carpaye.bankaccountkata.domain.model.deposit.OperationsRepository, com.thomas.carpaye.bankaccountkata.domain.model.history.OperationsRepository, com.thomas.carpaye.bankaccountkata.domain.model.balance.OperationsRepository {
    private Map<Account, List<Transaction>> operationByAccount = new HashMap<>();

    @Override
    public void add(Account account, Deposit deposit) {
        Balance actualBalance = getBalance(account);
        Balance newBalance = actualBalance.add(deposit);

        Transaction transaction = new Transaction.Builder()
                .withAmount(deposit.getAmount())
                .withBalance(newBalance.getValue())
                .build();

        add(account, transaction);
    }

    @Override
    public void add(Account account, Withdrawal withdrawal) {
        Balance actualBalance = getBalance(account);
        Balance newBalance = actualBalance.add(withdrawal);

        Transaction transaction = new Transaction.Builder()
                .withAmount(-withdrawal.getAmount())
                .withBalance(newBalance.getValue())
                .build();

        add(account, transaction);
    }

    private void add(Account account, Transaction transaction) {
        List<Transaction> transactions = getTransactions(account);
        transactions.add(transaction);
        operationByAccount.put(account, transactions);
    }

    private List<Transaction> getTransactions(Account account) {
        return Optional.ofNullable(operationByAccount.get(account))
                .orElse(new ArrayList<>());
    }

    @Override
    public History getHistory(Account account) {
        List<Operation> operations = getTransactions(account)
                .stream()
                .map(this::toOperation)
                .collect(Collectors.toList());

        return History.of(operations);
    }

    private Operation toOperation(Transaction transaction) {
        Balance balance = new Balance(transaction.getBalance());
        Amount amount = new Amount(transaction.getAmount());
        if (amount.isNegative()) {
            return Operation.createWithdrawal(amount, transaction.getDate(), balance);
        }
        return Operation.createDeposit(amount, transaction.getDate(), balance);
    }

    @Override
    public Balance getBalance(Account account) {
        int sum = getTransactions(account).stream().map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();
        return new Balance(sum);
    }
}
