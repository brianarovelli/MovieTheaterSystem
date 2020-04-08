import java.sql.Time;
import java.util.ArrayList;

public class Event {
	public EventType eventType;
	public ArrayList<Genre> genre;
	public Advisory advisory;
	public String title;
	public String description;
	public ArrayList<Actor> actors;
	public double rating;
	public double price;
	public int points;
	public Time showTime;
	public ArrayList<Review> reviews;
	private static final double DEFAULT_TICKET_PRICE = 9.00;
	
	/** public Event(EventType eventType, Genre genre, Advisory advisory, double price, int points, Time showTime)
	 * Creates Event object
	 * @param genre
	 * @param advisery
	 * @param price
	 * @param points
	 * @param showTime
	 */
	public Event(EventType eventType, String title, String description, ArrayList<Actor> actors, ArrayList<Genre> genre, Advisory advisory, double price, int points, Time showTime) {
		this.eventType = eventType;
		this.title = title;
		this.description = description;
		this.actors = actors;
		this.genre = genre;
		this.advisory = advisory;
		this.rating = 0;
		this.price = DEFAULT_TICKET_PRICE;
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

	public void printGenre() {
		for(int i = 0; i < genre.size(); i++) {
			System.out.print(genre.get(i) + " ");
		}
	}

	//GETTERS AND SETTERS	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Genre> getGenre() {
		return genre;
	}
	
	public ArrayList<String> getStringGenre() {
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < genre.size(); i++) {
			temp.add(genre.get(i).toString());
		}
		return temp;
	}

	public void setGenre(ArrayList<Genre> genre) {
		this.genre = genre;
	}
	
	public Advisory getAdvisory() {
		return advisory;
	}

	public void setAdvisery(Advisory advisory) {
		this.advisory = advisory;
	}
	
	public String getTitle() {
		return title;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setAdvisery(String title) {
		this.title = title;
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
