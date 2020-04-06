import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to run entire program
 *
 */
public class MovieDriver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		boolean repeat = true;
		ArrayList<Event> events = init();
		while(repeat) {
			printMenu();
			try {
				repeat = process(in.nextInt(), events);
			} catch(Exception e) { in.next(); }
		}
		in.close();
	}
	
	private static ArrayList<Event> init(){
		MovieLoader init = new MovieLoader();
		return init.Load("src/output.json");
	}
	
	private static void printMenu() {
		System.out.println("====================");
		System.out.println(" 1. Explore movies");
		System.out.println(" 2. Purchase a movie ticket");
		System.out.println(" 3. Log In");
		System.out.println(" 4. Account Options");
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
		case 3:
			return loginMenu();
		case 4:
			/*TODO This is where the employees can enter new events, or users can make reviews maybe?*/
			return true;
		default:
			return true;
		}
	}
	
	private static boolean ticketPurchaseMenu(ArrayList<Event> events) {
		System.out.println(" Please input the number corresponding to your movie choice");
		printEvents(events);
		int choice = in.nextInt();
		purchaseTicket(choice, events);
		//TODO: this entire method, i'll do it tomorrow when i wake up
		return true;
	}
	
	private static void purchaseTicket(int choice, ArrayList<Event> events) {
		/* Confirm movie choice */
		System.out.println("\nYou have selected the event: " + events.get(choice).getTitle() + "! Is this correct?");
		if(!confirm())
			return;
		
		/* Number of tickets */
		System.out.println("\nPlease enter the amount of tickets you would like to purchase:");
		int tickets = in.nextInt();
		double price = events.get(choice).getPrice()*tickets;
		System.out.println("You have entered: " + tickets + " tickets... This totals to a price of $" + price);
		
		
		
		//TODO We need to let the user pick seating location for scenario 2
		
		
		/* Adding food onto ticket */
		System.out.println("\nWould you like to add food and/or drink onto your ticket order?");
		if(confirm())
			addonPurchaseMenu();
		
		/* Total price, head to checkout or cancel order */
		System.out.println("\nYour order has come up to... $" + price + "! Would you like to head to checkout?");
		if(confirm())
			checkout();
		/* Finish Movie ticket order*/
		System.out.println("\nNow returning to Main Menu...");
	}
	
	private static boolean confirm() {
		System.out.println("Please enter 'Y' for yes or 'N' for no");
		String confirm = in.next();
		if(confirm.equals("N"))
			return false;
		return true;
	}
	
	private static void addonPurchaseMenu() {
		//TODO Here's where the user can add food and/or drinks to their order
	}
	
	private static void checkout() {
		/*Payment Information*/
		System.out.println("\nPlease enter anything and we will pretend it is payment information");
		in.next();
		System.out.println("Wonderful! That looks real. Thank you for your purchase.");
		
		/*Print tickets*/
		System.out.println("Would you like to print your tickets?");
		if(confirm())
			printTickets();
	}
	
	private static void printTickets() {
		/*TODO: We need it for scenario 1. Make a text file that shows their ticket. Make it look fun or something*/
	}
	
	private static boolean loginMenu() {
		/* TODO Here's where the user can log in. We need it for scenario 3 for employees to enter an event in*/
		return true;
	}
}


