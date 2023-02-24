package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotoTest {

    private final Account account = new Account();

    @Test
    void should_return_1_when_deposit_of_one() {
        Assertions.assertThat(account.deposit(1)).isEqualTo(1);

    }

    @Test
    void should_return_2_when_deposit_of_two() {
        Assertions.assertThat(account.deposit(2)).isEqualTo(2);

    }

    public static class Account {
        public Account() {

        }

        private int deposit(int i) {
            return i;
        }
    }
}
