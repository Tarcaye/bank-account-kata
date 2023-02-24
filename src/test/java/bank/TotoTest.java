package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotoTest {

    @Test
    void should_return_1_when_deposit_of_one() {
        Assertions.assertThat(deposit(1)).isEqualTo(1);
    }



    private int deposit(int i) {
        return 1;
    }
}
