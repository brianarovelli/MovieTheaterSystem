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
		return true;
	}
	
	private static void purchaseTicket(int choice, ArrayList<Event> events) {
		/* Confirm movie choice */
		System.out.println("\nYou have selected the event: " + events.get(choice).getTitle() + "! Is this correct?");
		if(!confirm())
			return;
		
		/* Number of tickets */
		System.out.println("\n******* PLEASE INPUT THE NUMBER OF TICKETS YOU WOULD LIKE TO PURCHASE *******");
		Ticket ticket = numberofTickets();
		
		
		//TODO We need to let the user pick seating location for scenario 2
		
		
		/* Adding food onto ticket */
		System.out.println("\nWould you like to add food and/or drink onto your ticket order?");
		if(confirm())
			ticket = addonPurchaseMenu(ticket);
		
		/* Total price, head to checkout or cancel order */
		System.out.println("\nYour order has come up to... $" + ticket.getCost() + "! Would you like to head to checkout?");
		if(confirm())
			checkout();
		/* Finish Movie ticket order*/
		System.out.println("\nNow returning to Main Menu...");
	}
	
	/** private static boolean confirm()
	 * Confirms prior choice of user
	 * @return choice
	 */
	private static boolean confirm() {
		System.out.println("Please enter 'Y' for yes or 'N' for no");
		String confirm = in.next();
		if(confirm.equals("N"))
			return false;
		return true;
	}
	
	/** private static Ticket numberofTickets()
	 * Gets ticket number order from User and creates the Ticket object
	 * @return Ticket
	 */
	private static Ticket numberofTickets() {
		Ticket ticket = new BaseTicket();
		System.out.println("\nPlease enter the amount of ADULT tickets you would like to purchase:");
		int adulttickets = in.nextInt();
		for(int i = 0; i < adulttickets; i++) {
			ticket = new AdultTicket(ticket);
		}
		
		System.out.println("\nPlease enter the amount of CHILD tickets you would like to purchase:");
		int childtickets = in.nextInt();
		for(int i = 0; i < childtickets; i++) {
			ticket = new ChildTicket(ticket);
		}
		
		System.out.println("\nPlease enter the amount of SENIOR tickets you would like to purchase:");
		int seniortickets = in.nextInt();
		for(int i = 0; i < seniortickets; i++) {
			ticket = new SeniorTicket(ticket);
		}
		
		int totaltickets = adulttickets + childtickets + seniortickets;
		printCurrentTicket(ticket);
		System.out.println("You have entered: " + totaltickets);
		
		return ticket;
	}
	
	private static Ticket addonPurchaseMenu(Ticket ticket) {
		//TODO Here's where the user can add food and/or drinks to their order
		boolean repeat = true;
		int choice;
		while(repeat) {
			printFoodMenu();
			try {
				choice = in.nextInt();
				switch(choice) {
				case -1:
					repeat = false;
					break;
				case 1:
					ticket = new Popcorn(ticket);
					printCurrentTicket(ticket);
					repeat = true;
					break;
				case 2:	
					ticket = new Soda(ticket);
					printCurrentTicket(ticket);
					repeat = true;
					break;
				case 3:
					ticket = new Candy(ticket);
					printCurrentTicket(ticket);
					repeat =  true;
					break;
				case 4:
					ticket = new Beer(ticket);
					printCurrentTicket(ticket);
					repeat = true;
					break;
				default:
					repeat = true;
					break;
				}
			} catch(Exception e) { in.next(); }
		}
		return ticket;
	}
	
	
	private static void printFoodMenu() {
		System.out.println("\nPlease select from the following list!");
		System.out.println("====================");
		System.out.println(" 1. Popcorn");
		System.out.println(" 2. Soda");
		System.out.println(" 3. Candy");
		System.out.println(" 4. Beer");
		System.out.println("-1. Quit food ordering");
		System.out.println("====================");
	}
	
	private static void printCurrentTicket(Ticket ticket) {
		System.out.println(ticket.getDescription());
		System.out.println("This totals to a price of $" + ticket.getCost());
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


