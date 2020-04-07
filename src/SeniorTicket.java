
public class SeniorTicket extends TicketDecorator {
	private final static double SENIOR_TICKET_COST = 12.00;
	private final static int SENIOR_TICKET_POINTS = 5;
	
	private Ticket ticket;
	
	/** public SeniorTicket (Ticket ticket)
	 * Creates new Senior Ticket object and sets Ticket
	 * @param ticket 
	 */
	
	public SeniorTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds Senior ticket onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "\n1 Senior Ticket";
	}
	
	/** public double getCost()
	 * Adds cost of Senior Ticket onto order
	 */
	public double getCost() {
		return ticket.getCost() + SENIOR_TICKET_COST;
	}
	
	/** public int getPoints()
	 * Adds points of added item onto order
	 */
	public int getPoints() {
		return ticket.getPoints() + SENIOR_TICKET_POINTS;
	}
}
