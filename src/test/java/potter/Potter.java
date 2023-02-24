package potter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Potter {

    @Test
    void one_book_costs_8_euros() {
        assertThat(new Books(new Book(1)).cost(this).getValue()).isEqualTo(8);

    }

    @Test
    void two_identical_books_costs_16_euros() {
        assertThat(new Books(new Book(1), new Book(1)).cost(this).getValue()).isEqualTo(8 * 2);
    }

    @Disabled
    @Test
    void two_different_books_costs_16_euros_plus_a_5_percent_discount() {
        assertThat(new Books(new Book(1), new Book(2)).cost(this).getValue()).isEqualTo(15.2d);
    }

    @Test
    void no_books_costs_nothing() {
        assertThat(new Books().cost(this).getValue()).isEqualTo(0);
    }


    private static class Book {
        private final int id;

        private Book(int bookId) {
            id = bookId;
        }
    }

    public class Price {
        private final int value;

        public Price(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static class Books {
        private final Book[] book;

        private Books(Book... book) {
            this.book = book;
        }

        private Price cost(Potter potter) {
            return potter.new Price(book.length * 8);
        }
    }
}
