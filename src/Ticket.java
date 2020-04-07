import java.util.ArrayList;

public abstract class Ticket {	
	protected Movie movie;
	protected String description;
	
	public String getDescription() {
		return description;
	}
	public abstract double getCost();
	
	public abstract int getPoints();
}