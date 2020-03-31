import java.util.ArrayList;

public abstract class Ticket {
public static int DEF_TICKET_PRICE = 10;	
	
	// will modify description and price in sublasses
	protected String description;
	protected int price = DEF_TICKET_PRICE;
	
	// Then the description for printed file with add movie name attribute to this
	public abstract String toString();
	
	public abstract double getCost();
}