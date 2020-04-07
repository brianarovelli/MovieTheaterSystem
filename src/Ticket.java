import java.util.ArrayList;

public abstract class Ticket {	
	protected Movie movie;
	protected String description;
	protected ArrayList<Seat> seat;
	protected Venue venue;
	
	public String getDescription() {
		return description;
	}
	public ArrayList<Seat> getSeat() {
		return seat;
	}
	public void setSeat(ArrayList<Seat>  seat) {
		this.seat = seat;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public abstract double getCost();
	
	public abstract int getPoints();
}