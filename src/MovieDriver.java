import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to run entire program
 *
 */
public class MovieDriver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
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
		return init.Load("./output.json");
	}
	/* Initial menu where user can input number in correspondence with where they want to go */
	private static void printMenu() {
		System.out.println("====================");
		System.out.println(" 1. Explore movies");
		System.out.println(" 2. Purchase a movie ticket");
		System.out.println(" 3. Log In");
		System.out.println(" 4. Create an Account");
		System.out.println(" 5. Account Options");
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
			return createAccountMenu();
		case 5:
			/*TODO This is where the employees can enter new events, or users can make reviews maybe?*/
			return true;
		default:
			return true;
		}
	}
	/* Menu where user can purchase ticket */
	private static boolean ticketPurchaseMenu(ArrayList<Event> events) {
		/* Menu to choose which movie you would like to see */
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
			checkout(ticket);
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
		/* User enters in # adult tickets */
		System.out.println("\nPlease enter the amount of ADULT tickets you would like to purchase:");
		int adulttickets = in.nextInt();
		for(int i = 0; i < adulttickets; i++) {
			ticket = new AdultTicket(ticket);
		}
		/* User enters in # child tickets */
		System.out.println("\nPlease enter the amount of CHILD tickets you would like to purchase:");
		int childtickets = in.nextInt();
		for(int i = 0; i < childtickets; i++) {
			ticket = new ChildTicket(ticket);
		}
		/* User enters # senior tickets */
		System.out.println("\nPlease enter the amount of SENIOR tickets you would like to purchase:");
		int seniortickets = in.nextInt();
		for(int i = 0; i < seniortickets; i++) {
			ticket = new SeniorTicket(ticket);
		}
		/* Algorithm for total # of tickets purchased */
		int totaltickets = adulttickets + childtickets + seniortickets;
		chooseSeats(ticket, totaltickets);
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
	/* Menu to order ticket add-ons such as food and drinks */
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
	/* Prompts user the total $ amount */
	private static void printCurrentTicket(Ticket ticket) {
		System.out.println(ticket.getDescription());
		System.out.println("This totals to a price of $" + ticket.getCost());
		System.out.println("If you are signed into an account, you will gain " + ticket.getPoints() + " points from this purchase!");
	}
	
	private static void checkout(Ticket ticket) {
		/*Payment Information*/
		System.out.println("\nPlease enter anything and we will pretend it is payment information");
		in.next();
		System.out.println("Wonderful! That looks real. Thank you for your purchase.");
		/*Print tickets*/
		System.out.println("Would you like to print your tickets?");
		if(confirm())
			printTickets(ticket);
	}
	/* Choose seats for ticket(s) */
	private static void chooseSeats(Ticket ticket, int totaltickets) {
		/* For some reason the venue wouldn't work without being set here. If you can fix, please try */
		Seat[][] seats = new Seat[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				seats[i][j] = new Seat(new int[2], SeatType.Reclining);
			}
		}
		ticket.venue = new Venue("Default", 0, 5, 5, seats, new ArrayList<Review>());
		for(int k = 0; k < totaltickets; k++) {
			for(int i = 0; i < ticket.venue.getSeats().length; i++) {
				System.out.print(i);
				for(int j = 0; j < ticket.venue.getSeats()[i].length; j++) {
					System.out.print("----");
				}
				System.out.println();
				for(int j = 0; j < ticket.venue.getSeats()[i].length; j++) {
					if(ticket.venue.getSeats()[i][j].taken)
						System.out.print("| X ");
					else
						System.out.print("| " + j + " ");
				}
				System.out.println("|");
				for(int j = 0; j < ticket.venue.getSeats()[i].length; j++) {
					System.out.print("-----");
				}
				System.out.println();
			}
			boolean rep = true;
			while(rep) {
				System.out.println("\nPlease select your row");
				int[] spot = new int[2];
				try {
					spot[0] = in.nextInt();
				} catch(Exception e) {
					in.next();
				}
				System.out.println("\nPlease select your column");
				try {
					spot[1] = in.nextInt();
				} catch(Exception e) {
					in.next();
				}
				if(ticket.venue.getSeats()[spot[0]][spot[1]].taken) {
					System.out.println("\nThat seat is taken! Please try again!");
				} else {
					rep = false;
					ticket.venue.getSeats()[spot[0]][spot[1]].taken = true;
					ticket.getSeat().add(new Seat(spot, SeatType.Reclining));
				}
			}
		}
	}
	/* Prints ticket information to a separate txt file */
	private static void printTickets(Ticket ticket) {
		File file = new File("./printedtickets.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(file));
			writer.println("====================");
			writer.println("PICKUP YOUR TICKETS AND PRODUCTS AT THE FRONT DESK");
			writer.println("\nTICKET ORDER");
			writer.println(ticket.getDescription());
			writer.println("\nSEATS:");
			for(int i = 0; i < ticket.getSeat().size(); i++) {
				Seat cur = ticket.getSeat().get(i);
				writer.println("Row: " + cur.spot[0] + " Col: " + cur.spot[1]);
			}
			writer.println("\nTOTAL COST");
			writer.println(ticket.getCost());
			writer.println("====================");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean loginMenu() {
		/* TODO Here's where the user can log in. We need it for scenario 3 for employees to enter an event in*/
		return true;
	}

	private static boolean createAccountMenu() {
		/* Menu to create a new account for users */
		AccountDatabase database = AccountDatabase.getDatabase();
		
		/*REMOVE THIS PART LATER.... JUST FOR TESTING*/
		System.out.println("Printing current accounts");
		showAccountDatabase();
		
		System.out.println("Please enter your first name:");
		String firstName = in.next();
		
		System.out.println("Please enter your last name:");
		String lastName = in.next();
		
		System.out.println("Please enter your username:");
		String username = in.next();
		
		System.out.println("Please enter your password:");
		String password = in.next();
		
		System.out.println("Please enter your email:");
		String email = in.next();
		
		database.addUserAccount(firstName, lastName, username, password, email);
		
		/*REMOVE THIS PART LATER.... JUST FOR TESTING*/
		showAccountDatabase();
		
		System.out.println("\nNow returning to Main Menu...");
		return true;
	}
	
	
	private static void showAccountDatabase() {
		AccountDatabase database = AccountDatabase.getDatabase();
		ArrayList<UserAccount> accounts = database.getAccounts();
		
		for(UserAccount account: accounts) {
			account.printInfomation();
		}
	}
}



