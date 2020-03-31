
public abstract class TicketDecorator extends Ticket {
	public final String ADD_ON = "Ticket add-on: ";
	public abstract String toString();
	public abstract double getCost();
}
