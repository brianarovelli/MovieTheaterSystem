import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class MovieTest {
Event eObj;

	@Test
	void test() {
	
		int num = 0;
		
		switch(num) {
		case 0:
			testConstructor();
		case 1:
			//testAddMovie
		case 3:
		
		}
	}

	void testConstructor() {
		EventType expectedType = EventType.MOVIE;
		ArrayList<Genre> expectedGenre = new ArrayList<Genre>();
		expectedGenre.add(Genre.DRAMA);
		Advisory expectedAdvisory = Advisory.PG13;
		String expectedTitle = "TDKR";
		String expectedDescription = "A Legend is Born";
		ArrayList<Actor> expectedActors = new ArrayList<Actor>();
		Actor actor1 = new Actor("Christian", "Bale");
		testActorConstructor(actor1);
		Actor actor2 = new Actor("Morgan", "Freeman");
		expectedActors.add(actor1);
		expectedActors.add(actor2);
		double expectedRating = 4;
		double expectedPrice = 9.0;
		int expectedPoints = 5;
		
		/* Couldn't locate where Time object was created so I didn't know how it's constructor worked, so for the purposes of testing this I temporarily removed the Time instance from the object */
		eObj = new Event (EventType.MOVIE, "TDKR", "A Legend is Born", expectedActors, expectedGenre, Advisory.PG13, 12.50, 5);
		
		assertEquals(expectedType, eObj.getType());
		assertEquals(expectedTitle, eObj.getTitle());
		assertEquals(expectedDescription, eObj.getDescription());
		assertEquals(expectedActors, eObj.getActors());
		assertEquals(expectedGenre, eObj.getGenre());
		assertEquals(expectedAdvisory, eObj.getAdvisory());
		assertEquals(expectedPrice, eObj.getPrice());
		assertEquals(expectedPoints, eObj.getPoints());
		
		
		
	}
	void testActorConstructor(Actor actor) {
		String expectedFirstName = "Christian";
		String expectedLastName = "Bale";
		
		String actualFirstName = actor.first;
		String actualLastName = actor.last;
		
		assertEquals(expectedFirstName, actualFirstName);
		assertEquals(expectedLastName, actualLastName);
	}

}
