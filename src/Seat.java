
public class Seat {
	public boolean taken;
	public SeatType type;
	public int[] spot;
	
	/** public Seat(SeatType type)
	 * Creates new Seat object
	 * @param type
	 */
	public Seat(int[] spot, SeatType type) {
		this.spot = spot;
		this.type = type;
		taken = false;
	}
}
