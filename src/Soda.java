
public class Soda extends TicketDecorator {
	private final double SODA_COST = 4.35;
	
	Ticket ticket;
	
	public Soda (Ticket ticket) {
		this.ticket = ticket;
	}
	public String toString() {
		return ticket.toString() + "/n" + ADD_ON + "Soda";
	}
	public double getCost() {
		return ticket.getCost() + SODA_COST;
	}
}
