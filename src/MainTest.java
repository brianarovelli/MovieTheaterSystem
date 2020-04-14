import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/* Use to test all things at once*/
public class MainTest {
	@Test
	public void main() {
		ActorTesting a = new ActorTesting();
		assertTrue(a.testActors());
		a.testActors();
		//With driver test, you will have to go through one ordering process in console.
		//This ensures maximum code coverage.
		DriverTest d = new DriverTest();
		assertTrue(d.testMain());
		d.testMain(); 
		MovieTest m = new MovieTest();
		assertTrue(m.test());
		m.test();
		AccountTest at = new AccountTest();
		assertTrue(at.testAll());
		at.testAll();
		TicketTesting t = new TicketTesting();
		assertTrue(t.testTicket());
		t.testTicket();
	}
}
