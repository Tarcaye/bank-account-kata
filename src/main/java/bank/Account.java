package bank;

import java.text.MessageFormat;
import java.util.Collections;

import static bank.Amount.createAmount;

class Account {

    private final Client client;
    private Amount balance;

    public Account(Client client) {
        this.client = client;
        balance = createAmount(0);
    }

    public void deposit(Amount amount) {
        balance = balance.add(amount);
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdraw(Amount amount) {
        if (balance.isLessThan(amount))
            throw new UnsupportedWithdrawalException(MessageFormat.format("Unable to withdraw this amount : {0}, balance: {1}, withdrawal: {2}", client, balance, amount));

        balance = balance.substract(amount);
    }

    public History history() {
        return new History(Collections.emptyList());
    }
}
