package bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit {
    private final Amount amount;
    private final Amount balance;
    private final Date date;

    public Deposit(Amount amount, Amount balance, Date date) {
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    String asString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String when = format.format(date);
        return "Operation : {type: Deposit, date: " + when + ", amount: " + amount + ", balance: " + balance + "}";
    }
}
