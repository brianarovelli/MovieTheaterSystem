import java.util.ArrayList;

public class ChildTicket extends TicketDecorator {
	private final static double CHILD_TICKET_COST = 10.00;
	private final static int CHILD_TICKET_POINTS = 5;
	
	private Ticket ticket;
	
	/** public ChildTicket (Ticket ticket)
	 * Creates new Child Ticket object and sets Ticket
	 * @param ticket 
	 */
	public ChildTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds Child ticket onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "\n1 Child Ticket";
	}
	
	/** public double getCost()
	 * Adds cost of Child Ticket onto order
	 */
	public double getCost() {
		return ticket.getCost() + CHILD_TICKET_COST;
	}
	
	/** public int getPoints()
	 * Adds points of added item onto order
	 */
	public int getPoints() {
		return ticket.getPoints() + CHILD_TICKET_POINTS;
	}
	
	/* GETTERS AND SETTERS */
	
	public Venue getVenue() {
		return ticket.getVenue();
	}
	public void setVenue(Venue venue) {
		ticket.setVenue(venue);
	}
	public ArrayList<Seat> getSeat() {
		return this.ticket.getSeat();
	}
	public void setSeat(ArrayList<Seat>  seat) {
		this.ticket.setSeat(seat);
	}
	
}
