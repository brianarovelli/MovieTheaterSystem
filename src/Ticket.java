import java.util.ArrayList;

public abstract class Ticket {	
	
	// will modify description and price in sublasses
	protected String description;
	
	// Then the description for printed file with add movie name attribute to this
	public abstract String toString();
	
	public abstract double getCost();
}