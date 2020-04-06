
public class Soda extends TicketDecorator {
	private final double SODA_COST = 4.35;
	
	Ticket ticket;
	
	/** public Soda (Ticket ticket)
	 * Creates new Soda object and sets Ticket
	 * @param ticket
	 */
	public Soda (Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds Soda onto order description
	 */
	public String toString() {
		return ticket.toString() + "/n" + ADD_ON + "Soda";
	}
	
	/** public double getCost()
	 * Adds cost of Soda onto order
	 */
	public double getCost() {
		return ticket.getCost() + SODA_COST;
	}
}
