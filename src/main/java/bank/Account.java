package bank;

import static bank.Amount.createAmount;

class Account {

    private Amount balance;

    public Account(Client client) {
        balance = createAmount(0);
    }

    public void deposit(Amount amount) {
        balance = amount.add(balance);
    }

    public Amount getBalance() {
        return balance;
    }

    public void withdraw(Amount amount) {
        balance = balance.substract(amount);
    }
}
