import java.util.ArrayList;

public abstract class Ticket {	
	protected String description;
	
	public String getDescription() {
		return description;
	}
	public abstract double getCost();
}