
public class SeniorTicket extends TicketDecorator {
	private final static double SENIOR_TICKET_COST = 12.00;
	
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
		return ticket.getDescription() + "/n" + "1 Senior Ticket";
	}
	
	/** public double getCost()
	 * Adds cost of Senior Ticket onto order
	 */
	public double getCost() {
		return ticket.getCost() + SENIOR_TICKET_COST;
	}
}
