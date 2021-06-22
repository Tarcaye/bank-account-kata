package bank;

import java.util.Objects;

public class Amount {
    private final long value;

    private Amount(long value) {
        this.value = value;
    }

    public static Amount createAmount(long value) {
        if (value < 0) throw new IllegalArgumentException(String.format("An amount cannot be negative : %d is not a valid amount", value));
        return new Amount(value);
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
        return createAmount(value + amount.value);
    }
}
