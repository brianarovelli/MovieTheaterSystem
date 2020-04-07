import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MovieWriter extends MovieConstants {
	public static void saveEvents() {
		MovieDatabase database = MovieDatabase.getDatabase();
		ArrayList<Event> events = database.getEvents();
		JSONArray jsonEvents = new JSONArray();
		
		/* Create all the JSON objects */
		for(int i = 0; i < events.size(); i++) {
			jsonEvents.add(getEventJSON(events.get(i)));
		}
		
		/* Write the JSON File */
		try(FileWriter file = new FileWriter(EVENTS_FILE)) {
			file.write(jsonEvents.toJSONString());
			file.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static Object getEventJSON(Event event) {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(EVENT_TITLE, event.getTitle());
		accountDetails.put(EVENT_DESCRIPTION, event.getDescription());

		JSONArray actors = new JSONArray();
		for(int i = 0; i < event.getActors().size(); i++) {
			actors.add(event.getActors().get(i).toString());
		}
		accountDetails.put(EVENT_ACTORS, actors);
		accountDetails.put(EVENT_RATING, event.getRating());
		accountDetails.put(EVENT_ADVISORY, event.getAdvisory().toString());
		
		JSONArray genres = new JSONArray();
		for(int i = 0; i < event.getGenre().size(); i++) {
			genres.add(event.getGenre().get(i).toString());
		}
		accountDetails.put(EVENT_GENRE, genres.toString());
		return accountDetails;
	}
}
