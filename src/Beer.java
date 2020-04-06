
public class Beer extends TicketDecorator {
	private final static double BEER_COST = 5.50;
	
	private Ticket ticket;
	
	/** public Beer (Ticket ticket)
	 * Creates new Beer object and sets Ticket
	 * @param ticket 
	 */
	
	public Beer (Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds beer onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "\n1 Beer";
	}
	
	/** public double getCost()
	 * Adds cost of Beer onto order
	 */
	public double getCost() {
		return ticket.getCost() + BEER_COST;
	}
}
