package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotoTest {

    @Test
    void name() {
        Assertions.assertThat(deposit(1)).isEqualTo(1);
    }

    private int deposit(int i) {
        return 0;    }
}
