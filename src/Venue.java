import java.util.ArrayList;

public class Venue {
	public String name;
	public double distance;
	private int rows,cols;
	private Seat[][] seats;
	private ArrayList<Review> reviews;
	private int amountOfSeatsInTheater;
	public int amountOfSeatsLeft = amountOfSeatsInTheater;
	
	/**
	 * General Constructor
	 * @param name
	 * @param distance
	 * @param rows
	 * @param cols
	 * @param seats
	 * @param reviews
	 */
	public Venue(String name, double distance, int rows, int cols, Seat[][] seats, ArrayList<Review> reviews) {
		this.name = name;
		this.distance = distance;
		this.rows = rows;
		this.cols = cols;
		this.seats = seats;
		this.reviews = reviews;
		this.amountOfSeatsInTheater = rows*cols;
		this.amountOfSeatsLeft = this.amountOfSeatsInTheater;
	}

	/* GETTERS AND SETTERS */ 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	public int getAmountOfSeatsInTheater() {
		return amountOfSeatsInTheater;
	}
	public int decSeatsLeft() {
		return amountOfSeatsLeft = amountOfSeatsLeft - 1;
	}
	public boolean canPurchaseThisAmount() {
		return amountOfSeatsLeft >= 0;
	}
}
