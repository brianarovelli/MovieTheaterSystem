import java.util.ArrayList;
// Add note to see confirm eGit works
public class Movie {
	public String name;
	public String description;
	public ArrayList<Actor> actors;
	public ArrayList<Genre> genres;
	public Movie(String name, String description, ArrayList<Actor> actors, ArrayList<Genre> genres) {
		this.name = name;
		this.description = description;
		this.actors = actors;
		this.genres = genres;
	}
}
