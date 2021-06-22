package bank;

public class Deposit {
    private final Amount amount;
    private final Amount balance;

    public Deposit(Amount amount, Amount balance) {
        this.amount = amount;
        this.balance = balance;
    }

    String asString() {
        return "Operation : {type: Deposit, date: 2012-07-10 14:58:00.000000, amount: " + amount + ", balance: " + balance + "}";
    }
}
