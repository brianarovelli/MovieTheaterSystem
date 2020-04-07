/* All available compatible event types*/

public enum EventType {
	MOVIE("MOVIE"), PLAY("PLAY"), CONCERT("CONCERT");
public final String type;
    
    /** private Genre(String genre)
     * Sets genre
     * @param genre - genre of an event
     */
	private EventType(String type) {
        this.type = type;
    }
}
