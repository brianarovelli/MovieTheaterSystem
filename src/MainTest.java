import org.junit.Test;
/* Use to test all things at once*/
public class MainTest {
	@Test
	public void main() {
		ActorTesting a = new ActorTesting();
		a.testActors();
		//With driver test, you will have to go through one ordering process in console.
		//This ensures maximum code coverage.
		DriverTest d = new DriverTest();
		d.testMain(); 
		MovieTest m = new MovieTest();
		m.test();
		AccountTest at = new AccountTest();
		at.testAll();
		TicketTesting t = new TicketTesting();
		t.testTicket();
	}
}
