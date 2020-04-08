public class Actor {
	public String first;
	public String last;
	
	/** public Actor(String first, String last)
	 * Creates new Actor object
	 * @param first - first name
	 * @param last - last name
	 */
	public Actor(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public String getName() {
		return first + " " + last;
	}
}
