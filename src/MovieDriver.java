import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to run entire program
 *
 */
public class MovieDriver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		ArrayList<Event> events = init();
		while(repeat) {
			printMenu();
			try {
				repeat = process(in.nextInt(), events);
			} catch(Exception e) { in.next(); }
		}
	}
	
	private static ArrayList<Event> init(){
		MovieLoader init = new MovieLoader();
		return init.Load("src/output.json");
	}
	
	private static void printMenu() {
		System.out.println("====================");
		System.out.println(" 1. Explore movies");
		System.out.println(" 2. Purchase a movie ticket");
		System.out.println("-1. Quit program");
		System.out.println("====================");
	}
	
	private static void printEvents(ArrayList<Event> events) {
		for(int i = 0; i < events.size(); i++) {
			System.out.println(i + ": " + events.get(i).getTitle());
		}
	}
	
	private static boolean process(int choice, ArrayList<Event> events) {
		switch(choice) {
		case -1:
			return false;
		case 1:
			printEvents(events);
			return true;
		case 2:	
			return ticketPurchaseMenu(events);
		default:
			return true;
		}
	}
	
	private static boolean ticketPurchaseMenu(ArrayList<Event> events) {
		System.out.println(" Please input the number corresponding to your movie choice");
		printEvents(events);
		//TODO: this entire method, i'll do it tomorrow when i wake up
		return true;
	}
	
}


