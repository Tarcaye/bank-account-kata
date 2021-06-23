package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit implements Operation {
    private final Amount amount;
    private final Amount balance;
    private final Date date;

    public Deposit(Amount amount, Amount balance, Date date) {
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    @Override
    public String asString() {
        String when = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return "Operation : {type: Deposit, date: " + when + ", amount: " + amount + ", balance: " + balance + "}";
    }
}
