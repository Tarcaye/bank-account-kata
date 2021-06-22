package bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaveMoneyTest {

    @Test
    void save_money() {
        Assertions.assertThat(new Account(new Client()).deposit(100)).isEqualTo(100);
    }

    private class Account {
        public Account(Client client) {
        }

        public int deposit(int i) {
            return 0;
        }
    }

    private class Client {
    }
}
