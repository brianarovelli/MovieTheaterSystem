import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class TicketTesting {
	double expectedCost;
	int expectedPoints;
	String expectedDescription;

	double actualCost;
	int actualPoints;
	String actualDescription;
	Ticket actualTicket;
	
	double expectedBaseCost = 0.00;
	double expectedChildCost = 10.00;
	double expectedAdultCost = 13.00;
	double expectedSeniorCost = 12.00;
	double expectedCandyCost = 3.25;
	double expectedBeerCost = 5.50;
	double expectedPopcornCost = 8.85;
	int expectedBasePoints = 0;
	int expectedTicketPoints = 5;
	int expectedCandyPoints = 1;
    	int expectedBeerPoints = 1; 
    	int expectedPopcornPoints = 1;
	String expectedBaseDescription = "Ticket includes: ";
	String expectedChildDescription = "\n1 Child Ticket";
	String expectedAdultDescription = "\n1 Adult Ticket";
	String expectedSeniorDescription = "\n1 Senior Ticket";
	String expectedCandyDescription = "\n1 Candy";
	String expectedBeerDescription = "\n1 Beer";
	String expectedPopcornDescription = "\n1 Popcorn";
	
	
	/**
	 * Verifies constructors for all classes associated with a ticket work correctly through a switch statement calling helper methods that add onto initial Ticket object.
	 * After verifying base constructor creates works, method successively calls helper methods to test subclasses separately.
	 */
	@Test
	void testTicket() {
		BaseTicket ticket = new BaseTicket();
		assertNotEquals(ticket, null);

		expectedCost = expectedBaseCost;
		expectedDescription = expectedBaseDescription;
		expectedPoints = expectedBasePoints;
		
		actualCost = ticket.getCost();
		actualPoints = ticket.getPoints();
		actualDescription = ticket.getDescription();
		
		assertEquals(actualCost, expectedBaseCost);
		assertEquals(actualPoints, expectedPoints);
		assertEquals(actualDescription, expectedDescription);
		
		/* Calls from switch statement add upon initialized BaseTicket with all each ticket type separately to test subclasses' functionality */
		
		int num = 0;
		while (num <= 3) {
			switch(num) {
			case 0:
				testChildTicket(ticket);
			case 1:
				testAdultTicket(ticket);
			case 2:
				testSeniorTicket(ticket);
			case 3:
				testErrorCases(ticket); /* need more work on this case's method call */
			case 4:
				/**
				 * Unsure how to test methods from driver so this case remains incomplete
				 */
				testTicketWriter(ticket);
			default:
				testChildTicket(ticket);
			}
			++num;
		}
	}
	/**
	 *  These comments apply to the following three methods in the form "Test<SubClass>"
	 * 
	 *  Determine if constructors successively add onto initial object and, if so, passes updated reference to further testing for object attributes.
	 *  Afterwards each method tests one of the three Add-On classes to ensure Decorator works 
	 *  @param ticket BaseTicket object 
	 */
	void testChildTicket (BaseTicket prevTicket) {		
		ChildTicket actual = new ChildTicket(prevTicket);
		assertNotEquals(actual, prevTicket);
		testChildAttributes(actual, prevTicket);
		testCandyAttributes(actual);
	}
	void testAdultTicket (BaseTicket prevTicket) {
		AdultTicket actual = new AdultTicket(prevTicket);
		assertNotEquals(actual, prevTicket);
		testAdultAttributes(actual, prevTicket);
		testBeerAttributes(actual);
	}
	void testSeniorTicket (BaseTicket prevTicket) {
		SeniorTicket actual = new SeniorTicket(prevTicket);
		assertNotEquals(actual, prevTicket);
		testSeniorAttributes(actual, prevTicket);
		testPopcornAttributes(actual);
	}

	/**
	 * These comments apply to the following three methods in form "test<SubClass>Attributes"
	 * Updates expected values in each method to validate equality with returned values from getters.
	 * @param actual <SubClass> is constructed object upon initial object from corresponding methods above
	 * @param baseTicket BaseTicket is the initial object from corresponding methods above before adding onto it
	 */
	void testChildAttributes (ChildTicket actual, BaseTicket baseTicket) {
		expectedCost = expectedChildCost;
		expectedPoints = expectedTicketPoints;
		expectedDescription = expectedBaseDescription + expectedChildDescription;
		
		actualCost = actual.getCost();
    	actualPoints = actual.getPoints();
		actualDescription = actual.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
	}
	void testAdultAttributes (AdultTicket actual, BaseTicket baseTicket) {
		expectedCost = expectedBaseCost + expectedAdultCost;
		expectedPoints = expectedBasePoints + expectedTicketPoints;
		expectedDescription = expectedBaseDescription + expectedAdultDescription;
		
		actualCost = actual.getCost();
		actualPoints = actual.getPoints();
		actualDescription = actual.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
	}
	void testSeniorAttributes (SeniorTicket actual, BaseTicket baseTicket) {
		expectedCost = expectedBaseCost + expectedSeniorCost;
		expectedPoints = expectedBasePoints + expectedTicketPoints;
		expectedDescription = expectedBaseDescription + expectedSeniorDescription;
		
		actualCost = actual.getCost();
		actualPoints = actual.getPoints();
		actualDescription = actual.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
	}
	
	
	/**
	 * These comments apply to the following three methods in the form "test<AddOn>Attributes>"
	 * 
	 * With same strategy as above three methods, all tests in these methods determine Decorator Pattern implemented properly 
	 * @param actual <SubClass> is the object passed in from either one of the three methods above corresponding to a subclass object
	 */
	void testCandyAttributes (ChildTicket actual) {
		expectedCost = expectedCost + expectedCandyCost;
		expectedPoints = expectedPoints + expectedCandyPoints;
		expectedDescription = expectedDescription + expectedCandyDescription;
		
		Candy candyObj = new Candy(actual);
		actualCost = candyObj.getCost();
		actualPoints = candyObj.getPoints();
		actualDescription = candyObj.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
		
	}
	void testBeerAttributes (AdultTicket actual) {
		expectedCost = expectedCost + expectedBeerCost;
		expectedPoints = expectedPoints + expectedBeerPoints;
		expectedDescription = expectedDescription + expectedBeerDescription;
		
		Beer beerObj = new Beer(actual);
		actualCost = beerObj.getCost();
		actualPoints = beerObj.getPoints();
		actualDescription = beerObj.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
	}
	void testPopcornAttributes (SeniorTicket actual) {
		expectedCost = expectedCost + expectedPopcornCost;
		expectedPoints = expectedPoints + expectedPopcornPoints;
		expectedDescription = expectedDescription + expectedPopcornDescription;
		
		Popcorn popcornObj = new Popcorn(actual);
		actualCost = popcornObj.getCost();
		actualPoints = popcornObj.getPoints();
		actualDescription = popcornObj.getDescription();
		
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedPoints, actualPoints);
		assertEquals(expectedDescription, actualDescription);
	}
	
	void testErrorCases(BaseTicket baseTicket) {
		/*
		 * Case 1: both row & column are greater than amount of rows & column w/in array representing theater
		 * Case 2: both row & column are less than amount of rows & column w/in array representing theater
		 * Case 3: row is greater than amount of rows, column is less than amount of columns
		 * Case 4: row is less than amount of rows, column is greater than amount of columns
		 */
		actualTicket = new ChildTicket(baseTicket);
		/* Case 1 */
		int [] overBounds = new int [2];
		for (int i = 0; i < overBounds.length; ++i) {
			overBounds[i] = 5;
		}
		/* theater holds 5 by 5 array, so this error case occurs when user enters invalid values for their desired seats */
		
		SeatType arbitraryType = SeatType.Normal;
		
		Seat case1 = new Seat(overBounds, arbitraryType);
		
		/* ensure the invalid entry wasn't set as attribute */
		assertNotEquals(case1, actualTicket.getSeat());
		
		/* test to determine that spot attribute wasn't erroneously set to the invalid seat entry */
		assertEquals(null, case1.getSpot());
		
		/* Case 2 */
		int [] lowerBounds = new int [2];
		for (int i = 0; i < lowerBounds.length; i++) {
			lowerBounds[i] = -1;
		}
		
		Seat case2 = new Seat(lowerBounds, arbitraryType);
		assertNotEquals(case2, actualTicket.getSeat());
		assertEquals(null, case2.getSpot());
		
		/* Case 3 */
		int [] mixCase1 = new int [2];
		mixCase1[0] = 5;
		mixCase1[1] = -1;
		Seat case3 = new Seat(mixCase1, arbitraryType);
		assertNotEquals(mixCase1, actualTicket.getSeat());
		assertEquals(null, case3.getSpot());
		
		int [] mixCase2 = new int [2];
		mixCase2[0] = -1;
		mixCase2[1] = 5;
		Seat case4 = new Seat(mixCase2, arbitraryType);
		assertNotEquals(mixCase2, actualTicket.getSeat());
		assertEquals(null, case4.getSpot());

	}
	
	void testTicketWriter(BaseTicket baseTicket) {
		expectedCost = expectedBaseCost + expectedChildCost + (2 * expectedCandyCost);
		expectedPoints = expectedBasePoints + expectedTicketPoints + (2 * expectedCandyPoints);
		expectedDescription = expectedBaseDescription + expectedChildDescription + expectedCandyDescription + expectedCandyDescription;
		
		actualTicket = new ChildTicket(baseTicket);
		actualTicket = new Candy(actualTicket);
		actualTicket = new Candy(actualTicket);
		actualCost = actualTicket.getCost();
		actualPoints = actualTicket.getPoints();
		actualDescription = actualTicket.getDescription();
		
		//printTickets(actualTicket);
	}
	
}
