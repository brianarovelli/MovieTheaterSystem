
public class Review {
	Event event;
	int rating;
	String description;
	
	/** public Review(Event event, double rating, String description)
	 * Creates new Review object associated with an event
	 * @param event
	 * @param rating
	 * @param description
	 */
	public Review(Event event, int rating, String description) {
		/* User can rate and comment on bought event */
		this.event = event;
		this.rating = rating;
		this.description = description;
	}
	
	//GETTERS AND SETTERS
	
	public int getRating() {
		return rating;
	}

	public String getDescription() {
		return description;
	}
	public String getEventTitle() {
		return event.getTitle();
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
