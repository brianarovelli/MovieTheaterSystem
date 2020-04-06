
public class Seat {
	public boolean taken;
	public SeatType type;
	
	/** public Seat(SeatType type)
	 * Creates new Seat object
	 * @param type
	 */
	public Seat(SeatType type) {
		this.type = type;
		taken = false;
	}
}
