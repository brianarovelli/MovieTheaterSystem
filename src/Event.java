import java.sql.Time;
import java.util.ArrayList;

public class Event {
	public EventType eventType;
	public Genre genre;
	public Advisory advisory;
	public double rating;
	public double price;
	public int points;
	public Time showTime;
	public ArrayList<Review> reviews;
	
	/** public Event(EventType eventType, Genre genre, Advisory advisory, double price, int points, Time showTime)
	 * Creates Event object
	 * @param genre
	 * @param advisery
	 * @param price
	 * @param points
	 * @param showTime
	 */
	
	public Event(EventType eventType, Genre genre, Advisory advisory, double price, int points, Time showTime) {
		this.eventType = eventType;
		this.genre = genre;
		this.advisory = advisory;
		this.rating = 0;
		this.price = price;
		this.points = points;
		this.showTime = showTime;
		reviews = new ArrayList<Review>();
	}
	
	/** public void calculateRating()
	 * Calculates the rating of a movie based on the ArrayList of reviews
	 */
	
	public void calculateRating() {
		this.rating = 0;
		if(reviews.isEmpty()) {
			return;
		}

		for(Review review : reviews) {
			this.rating += review.getRating();
		}
		this.rating = this.rating / reviews.size();
	}
	
	/** public void addReview(Review review)
	 * Adds review to ArrayList reviews
	 * @param review
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Advisory getAdvisory() {
		return advisory;
	}

	public void setAdvisery(Advisory advisory) {
		this.advisory = advisory;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}
	
}
