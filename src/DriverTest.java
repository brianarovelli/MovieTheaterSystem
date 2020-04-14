import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public class DriverTest {
	MovieDriver d = new MovieDriver();
	@Test
	boolean testMain() {
		assertTrue(testMenu());
		assertTrue(testProcesses());
		assertTrue(testLogin());
		return true;
	}
	@Test
	boolean testMenu() {
		assertTrue(d.printMenu());
		return true;
	}
	@Test
	boolean testProcesses() {
		ArrayList<Event> e = MovieLoader.loadEvents();
		for(int i = 0; i < 7; i++) {
			try {
			d.process(i, e);
			} catch(Exception ex) { }
		}
		return true;
	}
	@Test
	boolean testLogin() {
		assertTrue(MovieDriver.loginMenu());
		return true;
	}
}
