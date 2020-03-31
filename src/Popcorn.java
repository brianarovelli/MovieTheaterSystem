
public class Popcorn extends TicketDecorator {
	private final static double POPCORN_COST = 8.85;
	
	Ticket ticket;

	public Popcorn(Ticket ticket) {
	this.ticket = ticket;
	}
	public String toString() {
	return ticket.toString() + "/n" + ADD_ON + "Popcorn";
	}
	public double getCost() {
	return ticket.getCost() + 8.85;
	}
}
