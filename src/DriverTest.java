import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public class DriverTest {
	@Test
	void testMain() {
		ArrayList<Event> e = MovieLoader.loadEvents();
		assertTrue(MovieDriver.process(0, e));
		assertTrue(MovieDriver.process(1, e));
		assertTrue(MovieDriver.process(2, e));
		assertTrue(MovieDriver.process(3, e));
		assertTrue(MovieDriver.process(4, e));
		assertTrue(MovieDriver.process(5, e));
		assertTrue(MovieDriver.process(6, e));
		assertTrue(MovieDriver.process(7, e));
	}
}
