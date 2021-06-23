package bank;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

import static bank.Amount.createAmount;

class Account {

    private final Client client;
    private Amount balance;
    private final History history;

    public Account(Client client) {
        this.client = client;
        balance = createAmount(0);
        history = new History(new ArrayList<>());
    }

    public void deposit(Amount amount, Date date) {
        balance = balance.add(amount);
        history.addDeposit(amount, balance, date);
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdraw(Amount amount, Date date) {
        if (balance.isLessThan(amount))
            throw new UnsupportedWithdrawalException(MessageFormat.format("Unable to withdraw this amount : {0}, balance: {1}, withdrawal: {2}", client, balance, amount));

        balance = balance.substract(amount);
        history.addWithdraw(amount, balance, date);
    }

    public History history() {
        return history;
    }
}
