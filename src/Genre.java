
public enum Genre {
	COMEDY("COMEDY"), SCIFI("SCIFI"), HORROR("HORROR"), ROMANCE("ROMANCE"), ACTION("ACTION"), THRILLER("THRILLER"), 
	DRAMA("DRAMA"), MYSTERY("MYSTERY"),CRIME("CRIME"), ANIMATION("ANIMATION"), ADVENTURE("ADVENTURE"), MUSIC("MUSIC"), 
	FANTASY("FANTASY"), SUPERHERO("SUPERHERO"), ANIME("ANIME"), WAR("WAR"), HISTORY("HISTORY"), KIDS("KIDS"), FAMILY("FAMILY"),
	MUSICAL("MUSICAL"), BIOGRAPHY("BIOGRAPHY");
	
    public final String genre;
    
    /** private Genre(String genre)
     * Sets genre
     * @param genre - genre of an event
     */
	private Genre(String genre) {
        this.genre = genre;
    }
}
