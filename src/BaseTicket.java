import java.util.ArrayList;

public class BaseTicket extends Ticket{
	
	/** public BaseTicket()
	 * Creates BaseTicket to add drinks and tickets onto
	 */
	public BaseTicket() {
		this.description = "Ticket includes: ";
		Seat[][] seats = new Seat[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				seats[i][j] = new Seat(new int[2], SeatType.Reclining);
			}
		}
		this.venue = new Venue("Default", 0, 5, 5,seats, new ArrayList<Review>());
		this.seat = new ArrayList<Seat>();
	}
	
	/* GETTERS AND SETTERS */
	
	public Venue getVenue() {
		return venue;
	}
	
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public ArrayList<Seat> getSeat() {
		return seat;
	}
	
	public void setSeat(ArrayList<Seat>  seat) {
		this.seat = seat;
	}
	
	public double getCost() {
		/* Creates ticket with no entry, must be bought to gain entry */
		return 0.0;
	}
	
	public int getPoints() {
		return 0;
	}
}
