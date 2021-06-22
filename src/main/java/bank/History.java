package bank;

import java.util.List;

public class History {
    private final List<Object> value;

    public History(List<Object> value) {
        this.value = value;
    }

    public List<Object> asList() {
        return value;
    }

}
