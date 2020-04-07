import java.sql.Time;
import java.util.ArrayList;

public class MovieDatabase {
	private static MovieDatabase eventDatabase = null;
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	private MovieDatabase() {
		eventList = MovieLoader.loadEvents();
	}
	
	public static MovieDatabase getDatabase() {
		if(eventDatabase == null) {
			eventDatabase = new MovieDatabase();
		}
		return eventDatabase;
	}
	
	public ArrayList<Event> getEvents() {
		return eventList;
	}
	
	public void addEvent(EventType eventType, String title, String description, ArrayList<Actor> actors, ArrayList<Genre> genre, Advisory advisory, double price, int points, Time showTime) {
		eventList.add(new Event(eventType, description, description, actors, genre, advisory, price, points, showTime));
		MovieWriter.saveEvents();
	}
}
