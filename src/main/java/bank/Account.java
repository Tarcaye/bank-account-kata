package bank;

class Account {

    private Amount balance;

    public Account(Client client) {
        balance = Amount.createAmount(0);
    }

    public void deposit(Amount amount) {
        balance = amount.add(balance);
    }

    public Amount getBalance() {
        return balance;
    }
}
