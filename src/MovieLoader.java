import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieLoader{
	/**
	 * Loads movies from json
	 * @param path Path to file
	 * @return ArrayList of movies
	 */
	public static ArrayList<Movie> Load(String path) {
		try {
			//Load JSON file
			FileReader reader = new FileReader(path);
			JSONArray moviesJSON = (JSONArray)new JSONParser().parse(reader);
			//Create ArrayList to be filled
			ArrayList<Movie> movies = new ArrayList<Movie>();
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
				//Add new movie to movie ArrayList
				movies.add(new Movie(n, d, a, g));
			}
			return movies;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}