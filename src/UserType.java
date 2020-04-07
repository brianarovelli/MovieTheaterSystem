public enum UserType {
    GUEST("Guest"), DISABLED("Disabled"), TEACHER("Teacher"), STUDENT("Student"), EMPLOYEE("Employee"), MILITARY("Military"), ADMIN("Admin");
    //Different categories the user can choose when ordering a ticket
 public final String type;
    
    /** private Genre(String genre)
     * Sets genre
     * @param genre - genre of an event
     */
	private UserType(String type) {
        this.type = type;
    }
}
