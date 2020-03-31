
public class Beer extends TicketDecorator {
	private final static double BEER_COST = 5.50;
	
	private Ticket ticket;
	
	public Beer (Ticket ticket) {
		this.ticket = ticket;
	}
	public String toString() {
		return ticket.toString() + "/n" + ADD_ON + " Beer";
	}
	public double getCost() {
		return ticket.getCost() + BEER_COST;
	}
}
