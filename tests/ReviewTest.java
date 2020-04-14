import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {
    Review review;
            Event Movie;

    @Before
    public void setUp() throws Exception {
        review = new Review(Movie, 5, "Amazing");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetRating() {
        assertEquals(5, review.getRating());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Amazing", review.getDescription());
    }

    @Test
    public void testGetEventTitle() {
        assertEquals(Movie, review.getEventTitle());
    }

    @Test
    public void testSetDescription() {
        review.setDescription("This movie was horrible.");
        assertEquals("This movie was horrible.", review.getDescription());
    }

    @Test
    public void testSetRating() {
        review.setRating(1);
        assertEquals(1, review.getRating());
    }
}