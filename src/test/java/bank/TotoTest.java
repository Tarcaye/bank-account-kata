package bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotoTest {

    private final Account account = new Account();

    @Test
    void should_return_1_when_deposit_of_one() {
        assertThat(account.deposit(new Amount(1))).isEqualTo(new Amount(1));
    }

    @Test
    void should_return_2_when_deposit_of_two() {
        assertThat(account.deposit(new Amount(2))).isEqualTo(new Amount(2));
    }

    public static class Account {
        public Account() {

        }

        private Amount deposit(Amount amount) {
            return amount;
        }
    }
}
