package example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("test");
        Movie[] movies = {
            new Movie("ABC", Movie.NEW_RELEASE),
            new Movie("XYZ", Movie.REGULAR),
            new Movie("123", Movie.CHILDRENS)
        };
        for (Movie movie : movies) {
            customer.addRental(new Rental(movie, 7));
        }
    }

    @Test
    public void testStatement() {
        String statement = customer.statement();
        assertTrue(
                statement.contains("ABC	21.0")
                && statement.contains("XYZ	9.5")
                && statement.contains("123	7.5")
                && statement.contains("Amount owed is 38.0")
                && statement.contains("You earned 4 frequent renter points")
        );
    }

}
