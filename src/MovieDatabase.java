import java.sql.Time;
import java.util.ArrayList;

public class MovieDatabase {
	private static MovieDatabase eventDatabase = null;
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	private MovieDatabase() {
		eventList = MovieLoader.loadEvents();
	}
	
	/** public static MovieDatabase getDatabase()
	 * Create instance of MovieDatabase
	 * @return
	 */
	public static MovieDatabase getDatabase() {
		if(eventDatabase == null) {
			eventDatabase = new MovieDatabase();
		}
		return eventDatabase;
	}
	
	/** public ArrayList<Event> getEvents()
	 * Return list of events
	 * @return
	 */
	public ArrayList<Event> getEvents() {
		return eventList;
	}
	
	/** public void addEvent(EventType eventType, String title, String description, ArrayList<Actor> actors, ArrayList<Genre> genre, Advisory advisory, double price, int points, Time showTime)
	 * Create new Event and add to list of events
	 * @param eventType
	 * @param title
	 * @param description
	 * @param actors
	 * @param genre
	 * @param advisory
	 * @param price
	 * @param points
	 * @param showTime
	 */
	public void addEvent(EventType eventType, String title, String description, ArrayList<Actor> actors, ArrayList<Genre> genre, Advisory advisory, double price, int points, Time showTime) {
		eventList.add(new Event(eventType, description, description, actors, genre, advisory, price, points));
		MovieWriter.saveEvents();
	}
}
