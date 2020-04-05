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
		return init.Load("./output.json");
	}
	
	private static void printMenu() {
		System.out.println("====================");
		System.out.println(" 1. Explore movies");
		System.out.println("-1. Quit program");
		System.out.println("====================");
	}
	
	private static boolean process(int choice, ArrayList<Event> events) {
		switch(choice) {
		case -1:
			return false;
		case 1:
			for(int i = 0; i < events.size(); i++) {
				System.out.println(events.get(i).getTitle());
			}
			return true;
		default:
			return true;
		}
	}
	
}


