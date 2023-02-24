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

    @Test
    void a_new_account_have_a_balance_of_0() {
        assertThat(account.balance()).isEqualTo(new Amount(0));
    }

    public static class Account {

        private Amount amount ;

        public Account() {

        }

        private Amount deposit(Amount amount) {
            this.amount = amount;
            return this.amount;
        }

        public Amount balance() {
            return new Amount(0);
        }
    }
}
