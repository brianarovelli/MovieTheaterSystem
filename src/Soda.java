
public class Soda extends TicketDecorator {
	private final static double SODA_COST = 4.35;
	private final static int SODA_POINTS = 1;
	
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
	public String getDescription() {
		return ticket.getDescription() + "\n1 Soda";
	}
	
	/** public double getCost()
	 * Adds cost of Soda onto order
	 */
	public double getCost() {
		return ticket.getCost() + SODA_COST;
	}
	
	/** public int getPoints()
	 * Adds points of added item onto order
	 */
	public int getPoints() {
		return ticket.getPoints() + SODA_POINTS;
	}
}
