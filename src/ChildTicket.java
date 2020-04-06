
public class ChildTicket extends TicketDecorator {
	private final static double CHILD_TICKET_COST = 10.00;
	
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
		return ticket.getDescription() + "/n" + "1 Child Ticket";
	}
	
	/** public double getCost()
	 * Adds cost of Child Ticket onto order
	 */
	public double getCost() {
		return ticket.getCost() + CHILD_TICKET_COST;
	}
}
