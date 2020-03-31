
public class Candy extends TicketDecorator {
	private static final double CANDY_COST = 3.25;
	
	Ticket ticket;
	
	public Candy (Ticket ticket) {
		this.ticket = ticket;
	}
	public String toString() {
		return ticket.toString() + "/n" + ADD_ON + "Candy";
	}
	public double getCost() {
		return ticket.getCost() + CANDY_COST;
	}
}
