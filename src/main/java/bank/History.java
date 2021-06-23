package bank;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private final List<Operation> value;

    public History(List<Operation> value) {
        this.value = value;
    }

    public List<String> asStrings() {
        return value.stream().map(Operation::asString).collect(Collectors.toList());
    }

    public void addDeposit(Amount amount, Amount balance, Date date) {
        value.add(new Deposit(amount, balance, date));
    }

    public void addWithdraw(Amount amount, Amount balance, Date date) {
        value.add(new Withdraw(amount, balance, date));
    }
}
