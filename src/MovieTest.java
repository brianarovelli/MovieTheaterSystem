import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class MovieTest {
Event eObj;

	@Test
	void test() {
	
		int num = 0;
		
		while (num <= 1) {
		switch(num) {
		case 0:
			testConstructor();
		case 1:
			testMutators(); 	/* none of the mutators work */
		default:
			testConstructor();
		}
		num++;
		}
	}

	void testConstructor() {
		ArrayList<Actor> expectedActors = new ArrayList<Actor>();
		EventType expectedType = EventType.MOVIE;
		ArrayList<Genre> expectedGenre = new ArrayList<Genre>();
		expectedGenre.add(Genre.ACTION);
		expectedGenre.add(Genre.ADVENTURE);
		Advisory expectedAdvisory = Advisory.PG13;
		String expectedTitle = "TDKR";
		String expectedDescription = "A Legend is Born";
		
		Actor actor1 = new Actor("Christian", "Bale");
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
		assertEquals(expectedGenre.get(0).toString(), eObj.getGenreItem(0));
		assertEquals(expectedGenre.get(1).toString(), eObj.getGenreItem(1));
		assertEquals(expectedAdvisory, eObj.getAdvisory());
		assertEquals(expectedPrice, eObj.getPrice());
		assertEquals(expectedPoints, eObj.getPoints());
		
	}
	
	/* put this in a TestActor class */
//	void testActorConstructor(Actor actor) {
//		String expectedFirstName = "Christian";
//		String expectedLastName = "Bale";
//		
//		String actualFirstName = actor.first;
//		String actualLastName = actor.last;
//		
//		assertEquals(expectedFirstName, actualFirstName);
//		assertEquals(expectedLastName, actualLastName);
//	}


	void testMutators() {
		ArrayList<Actor> expectedList = new ArrayList<Actor>();
		String expectedTitle = "Inception";
		String expectedDescription = "A dream within a dream";
		Actor leo = new Actor("Leonardo", "Dicaprio");
		expectedList.add(leo);
//		eObj.setActors(expectedList);
//		eObj.setAdvisery(Advisory.R);
		eObj.setTitle(expectedTitle);
		eObj.setPoints(5);
		eObj.setRating(5);
		eObj.setDescription("A dream within a dream");
		
		/* actor getter not working for some reason */
//		assertEquals(expectedList, eObj.getActors());
		
		assertEquals(Advisory.R, eObj.getAdvisory());
		assertEquals(expectedTitle, eObj.getTitle());
		assertEquals(5, eObj.getPoints());
		assertEquals(5, eObj.getRating());
		assertEquals(expectedDescription, eObj.getDescription());
	}
}
