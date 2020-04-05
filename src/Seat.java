
public class Seat {
	public boolean taken;
	public SeatType type;
	
	public Seat(SeatType type) {
		this.type = type;
		taken = false;
	}
}
