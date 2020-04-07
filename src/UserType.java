public enum UserType {
    Guest("Guest"), Disabled("Disabled"), Teacher("Teacher"), Student("Student"), Employee("Employee"), Military("Military"), Admin("Admin");
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
