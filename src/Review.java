
public class Review {
	Event event;
	double rating;
	String description;
	
	public Review(Event event, double rating, String description) {
		this.event = event;
		this.rating = rating;
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
