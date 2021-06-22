package bank;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public long asLong() {
        return value;
    }
}
