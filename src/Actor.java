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
	
	/** public String getFirstName()
	 * Returns first name of Actor
	 * @return
	 */
	public String getFirstName() {
		return first;
	}

	/** public String getLastName()
	 * Returns last name of Actor
	 * @return
	 */
	public String getLastName() {
		return last;
	}

	
	/** public String getName()
	 * Returns full name of Actor
	 * @return
	 */
	public String getName() {
		return first + " " + last;
	}
}
