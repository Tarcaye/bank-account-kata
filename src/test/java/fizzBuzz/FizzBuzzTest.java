package fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FizzBuzzTest {

    @Test
    void should_return_a_number() {
        assertThat(FizzBuzzNumber.of(1).fizzBuzz()).isEqualTo("1");
    }

    @Test
    void should_return_a_number_2() {
        assertThat(FizzBuzzNumber.of(2).fizzBuzz()).isEqualTo("2");
    }

    @Test
    void should_fizz_for_3() {
        assertThat(FizzBuzzNumber.of(3).fizzBuzz()).isEqualTo("FIZZ");
    }

    @Test
    void should_fizz_for_a_multiple_of_3() {
        assertThat(FizzBuzzNumber.of(33).fizzBuzz()).isEqualTo("FIZZ");
    }


    @Test
    void should_fizz_for_5() {
        assertThat(FizzBuzzNumber.of(5).fizzBuzz()).isEqualTo("BUZZ");
    }

    @Test
    void should_return_an_error_for_negative_number() {
        assertThatThrownBy(() -> FizzBuzzNumber.of(-768).fizzBuzz())
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("-768 is not a valid FizzBuzz number");
    }

    private static class FizzBuzzNumber {
        private final int number;

        private FizzBuzzNumber(int number) {
            this.number = number;
        }

        private static FizzBuzzNumber of(int number) {
            if (number < 0) {
                throw new IllegalArgumentException(number + " is not a valid FizzBuzz number");
            }
            return new FizzBuzzNumber(number);
        }

        public int getNumber() {
            return number;
        }

        private boolean isAMultipleOf(int divisor) {
            return getNumber() % divisor == 0;
        }

        private String fizzBuzz() {
            if (isAMultipleOf(5)) return "BUZZ";
            if (isAMultipleOf(3)) return "FIZZ";
            return "" + getNumber();
        }
    }
}
