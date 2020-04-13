
public class Seat {
	public boolean taken;
	public SeatType type;
	public int[] spot;
	
	/** public Seat(SeatType type)
	 * Creates new Seat object
	 * @param type
	 */
	public Seat(int[] spot, SeatType type) {
		this.setSpot(spot);
		this.type = type;
		taken = false;
	}
	public int [] getSpot() {
		return spot;
	}
	public void setSpot(int [] spot) {
		for (int i = 0; i < spot.length; i++) {
			if (spot[i] >= 5 || spot[i] < 0) {
				spot = null;
				break;
			}
			continue;
		}
		spot = spot;
	}
}
