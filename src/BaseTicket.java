
public class BaseTicket extends Ticket{
	public BaseTicket() {
		this.description = "Ticket includes: ";
	}
	
	public double getCost() {
		/* Creates ticket with no entry, must be bought to gain entry */
		return 0.0;
	}
}
