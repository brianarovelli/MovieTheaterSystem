import java.util.ArrayList;

public abstract class Ticket {	
	protected Event event;
	protected String description;
	protected ArrayList<Seat> seat;
	public Venue venue;
	
	/* GETTERS AND SETTERS */ 
	
	public Event getEvent() {
		return event;
	}
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
	public int getAmountOfSeats() {
		return venue.getAmountOfSeatsInTheater();
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public abstract double getCost();
	
	public abstract int getPoints();
	
	public int decrementSeatsLeft() {
		return this.venue.decSeatsLeft();
	}
}