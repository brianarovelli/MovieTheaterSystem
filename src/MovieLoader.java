import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieLoader extends MovieConstants {
	/**
	 * Loads movies from json
	 * @param path Path to file
	 * @return ArrayList of movies
	 */
	public static ArrayList<Event> loadEvents() {
		try {
			//Load JSON file
			FileReader reader = new FileReader(EVENTS_FILE);
			JSONArray moviesJSON = (JSONArray)new JSONParser().parse(reader);
			//Create ArrayList to be filled
			ArrayList<Event> movies = new ArrayList<Event>();
			//Cycle through array of JSON Objects
			for(int i = 0; i < moviesJSON.size(); i++) {
				JSONObject movieJSON = (JSONObject)moviesJSON.get(i);
				//Get parameters for movies from JSON
				String n = movieJSON.get("name").toString();
				String d = movieJSON.get("description").toString();
				//Create and fill ArrayList of actors
				JSONArray aArray = (JSONArray)movieJSON.get("actors");
				ArrayList<Actor> a = new ArrayList<Actor>();
				for(int j = 0; j < aArray.size(); j++) {
					String[] name = aArray.get(j).toString().split(" ");
					a.add(new Actor(name[0], name[name.length-1]));
				}
				//Create and fill ArrayList of genres
				String gString = (String)movieJSON.get("genre");
				String[] gSplit = gString.split(", ");
				ArrayList<Genre> g = new ArrayList<Genre>();
				for(int j = 0; j < gSplit.length; j++) {
					gSplit[j] = gSplit[j].replace("-", "");
					g.add(Genre.valueOf(gSplit[j].strip().toUpperCase()));
				}
				Advisory ad = Advisory.valueOf(movieJSON.get("advisory").toString().toUpperCase());
				//Add new movie to movie ArrayList
				movies.add(new Event(EventType.MOVIE, n, d, a, g, ad, 0, 0, null));
			}
			return movies;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}