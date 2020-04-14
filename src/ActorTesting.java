import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ActorTesting {
	@Test
	public boolean testActors() {
		testActorConstructor(new Actor("Christian", "Bale"));
		return true;
	}
	
	void testActorConstructor(Actor actor) {
	String expectedFirstName = "Christian";
	String expectedLastName = "Bale";
	
	String actualFirstName = actor.getFirstName();
	String actualLastName = actor.getLastName();
	
	assertEquals(expectedFirstName, actualFirstName);
	assertEquals(expectedLastName, actualLastName);
	assertEquals(actor.getName(), expectedFirstName + " " + expectedLastName);
	}
}
