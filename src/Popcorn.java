
public class Popcorn extends TicketDecorator {
	private final static double POPCORN_COST = 8.85;
	
	Ticket ticket;

	/** public Popcorn(Ticket ticket)
	 * Creates new Popcorn object and sets Ticket
	 * @param ticket
	 */
	public Popcorn(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds Popcorn onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "/n" + "1 Popcorn";
	}
	
	/** public double getCost()
	 * Adds cost of Popcorn onto order
	 */
	public double getCost() {
		return ticket.getCost() + POPCORN_COST;
	}
}
