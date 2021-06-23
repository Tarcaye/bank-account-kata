package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdraw extends Deposit {
    private final Amount amount;
    private final Amount balance;
    private final Date date;

    public Withdraw(Amount amount, Amount balance, Date date) {
        super(amount, balance, date);
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    String asString() {
        String when = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return "Operation : {type: Withdraw, date: " + when + ", amount: " + amount + ", balance: " + balance + "}";
    }
}
