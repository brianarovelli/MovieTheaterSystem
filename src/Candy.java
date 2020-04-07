
public class Candy extends TicketDecorator {
	private static final double CANDY_COST = 3.25;
	private static final int CANDY_POINTS = 1;
	
	Ticket ticket;
	
	/** public Candy (Ticket ticket)
	 * Creates new Candy object and sets Ticket
	 * @param ticket
	 */
	public Candy (Ticket ticket) {
		this.ticket = ticket;
	}
	
	/** public String toString()
	 * Adds Candy onto order description
	 */
	public String getDescription() {
		return ticket.getDescription() + "\n1 Candy";
	}
	
	/** public double getCost()
	 * Adds cost of Candy onto order
	 */
	public double getCost() {
		return ticket.getCost() + CANDY_COST;
	}
	
	/** public int getPoints()
	 * Adds points of added item onto order
	 */
	public int getPoints() {
		return ticket.getPoints() + CANDY_POINTS;
	}
}
