package bank;

import java.util.Objects;

public class Amount {
    private final long value;

    public Amount(long value) {
        if (value < 0) throw new IllegalArgumentException("An amount cannot be negative : -100 is not a valid amount");
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    Amount add(Amount amount) {
        return new Amount(value + amount.value);
    }
}
