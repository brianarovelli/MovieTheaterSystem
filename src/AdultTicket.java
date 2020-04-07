import java.util.ArrayList;

public class AdultTicket extends TicketDecorator{

	private final static double ADULT_TICKET_COST = 13.00;
	private final static int ADULT_TICKET_POINTS = 5;
	private Ticket ticket;
	
	/** public AdultTicket (Ticket ticket)
	 * Creates new Adult Ticket object and sets Ticket
	 * @param ticket 
	 */
	
	public AdultTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds adult ticket onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "\n1 Adult Ticket";
	}
	
	/** public double getCost()
	 * Adds cost of Adult Ticket onto order
	 */
	public double getCost() {
		return ticket.getCost() + ADULT_TICKET_COST;
	}
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
	
	/** public int getPoints()
	 * Adds points of added item onto order
	 */
	public int getPoints() {
		return ticket.getPoints() + ADULT_TICKET_POINTS;
	}

}
