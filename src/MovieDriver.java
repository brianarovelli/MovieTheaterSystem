import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to run entire program
 *
 */
public class MovieDriver {
	static Scanner in = new Scanner(System.in);
	static UserType curUser = UserType.GUEST;
	static ArrayList<Event> events;
	static ArrayList<UserAccount> accounts;
	
	public static void main(String[] args) {
		boolean repeat = true;
		events = initEvents();
		accounts = initAccounts();
		while(repeat) {
			printMenu();
			try {
				repeat = process(in.nextInt(), events);
			} catch(Exception e) { in.next(); }
		}
		in.close();
	}
	
	/** private static ArrayList<Event> init()
	 * Initialize the events from output.json
	 * @return
	 */
	private static ArrayList<Event> initEvents() {
		MovieLoader init = new MovieLoader();
		return init.loadEvents();
	}
	
	private static ArrayList<UserAccount> initAccounts() {
		AccountsLoader init = new AccountsLoader();
		return init.loadAccounts();
	}
	/** private static void printMenu()
	 * Initial menu where user can input number in correspondence with where they want to go
	 */
	private static void printMenu() {
		System.out.println("====================");
		System.out.println(" 1. Explore movies");
		System.out.println(" 2. Purchase a movie ticket");
		if(curUser == UserType.GUEST) {
		System.out.println(" 3. Log In");
		System.out.println(" 4. Create an Account");
		} else if (curUser == UserType.ADMIN){
		System.out.println(" 5. Account Options");
		} 
		System.out.println("-1. Quit program");
		System.out.println("====================");
	}
	
	/** private static void printEvents(ArrayList<Event> events)
	 * Prints events
	 * @param events
	 */
	private static void printEvents(ArrayList<Event> events) {
		for(int i = 0; i < events.size(); i++) {
			System.out.println(i + ": " + events.get(i).getTitle());
			System.out.println("\t Advisory: " + events.get(i).getAdvisory());
			System.out.print("\t Genre(s): ");
			events.get(i).printGenre();
			System.out.println("\n\t Rating: " + events.get(i).getRating());
			System.out.println("\t Description: " + events.get(i).getDescription());
		}
	}

	/** private static boolean process(int choice, ArrayList<Event> events)
	 * Initial menu directors from printMenu()
	 * @param choice - number choice from printMenu()
	 * @param events - list of all events
	 * @return
	 */
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
			return accountOptions();
		default:
			return true;
		}
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
	
	/** private static boolean ticketPurchaseMenu(ArrayList<Event> events)
	 * Menu option 2 where user can purchase ticket
	 * @param events - list of all events
	 * @return
	 */
	private static boolean ticketPurchaseMenu(ArrayList<Event> events) {
		/* Menu to choose which movie you would like to see */
		System.out.println(" Please input the number corresponding to your movie choice");
		printEvents(events);
		int choice = in.nextInt();
		purchaseTicket(choice, events);
		return true;
	}
	
	/** private static void purchaseTicket(int choice, ArrayList<Event> events)
	 * User purchases a ticket
	 * @param choice - movie number choice
	 * @param events
	 */
	private static void purchaseTicket(int choice, ArrayList<Event> events) {
		/* Confirm movie choice */
		System.out.println("\nYou have selected the event: " + events.get(choice).getTitle() + "! Is this correct?");
		if(!confirm())
			return;
		
		/* Number of tickets */
		System.out.println("\n******* PLEASE INPUT THE NUMBER OF TICKETS YOU WOULD LIKE TO PURCHASE *******");
		Ticket ticket = numberofTickets();
		
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
		
		/* User selects seats for their tickets */
		chooseSeats(ticket, totaltickets);
		printCurrentTicket(ticket);
		System.out.println("You have entered: " + totaltickets + " tickets");
		
		return ticket;
	}
	
	/** private static void chooseSeats(Ticket ticket, int totaltickets)
	 * Choose seats for ticket(s) 
	 * @param ticket - Ticket order
	 * @param totaltickets - total number of tickets
	 */
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
			/* Print grid of the seating chart */
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
				
				/* User inputs row */
				System.out.println("\nPlease select your row");
				int[] spot = new int[2];
				try {
					spot[0] = in.nextInt();
				} catch(Exception e) {
					in.next();
				}
				
				/* User inputs column */
				System.out.println("\nPlease select your column");
				try {
					spot[1] = in.nextInt();
				} catch(Exception e) {
					in.next();
				}
				
				/* Seat is taken */
				if(ticket.venue.getSeats()[spot[0]][spot[1]].taken) {
					System.out.println("\nThat seat is taken! Please try again!");
				} 
				else { /* Seat is not taken, User takes that spot and seat is added to Ticket */
					rep = false;
					ticket.venue.getSeats()[spot[0]][spot[1]].taken = true;
					ticket.getSeat().add(new Seat(spot, SeatType.Reclining));
				}
			}
		}
	}
	
	
	/** private static void printFoodMenu()
	 * Menu to order ticket add-ons such as food and drinks
	 */
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
	
	/** private static Ticket addonPurchaseMenu(Ticket ticket)
	 * User can add food and/or drinks to their ticket based on printFoodMenu()
	 * @param ticket - Ticket order
	 * @return - Ticket order
	 */
	private static Ticket addonPurchaseMenu(Ticket ticket) {
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
	
	/** private static void printCurrentTicket(Ticket ticket)
	 * Prompts user the list of items on ticket, total $ amount, and points they can receive if signed in
	 * @param ticket
	 */
	private static void printCurrentTicket(Ticket ticket) {
		System.out.println(ticket.getDescription());
		System.out.println("This totals to a price of $" + ticket.getCost());
		System.out.println("If you are signed into an account, you will gain " + ticket.getPoints() + " points from this purchase!");
	}
	
	/** private static void checkout(Ticket ticket)
	 * User payment checkout for their ticket order
	 * @param ticket - Ticket order
	 */
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
	
	/** private static void printTickets(Ticket ticket)
	 * Prints ticket information to a separate txt file, printedtickets.txt
	 * @param ticket - Ticket order
	 */
	private static void printTickets(Ticket ticket) {
		File file = new File("src/printedtickets.txt");
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
	
	/** private static boolean loginMenu()
	 * User logs into their account in system
	 * @return
	 */
	private static boolean loginMenu() {

		Scanner in = new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Enter username");
		String username = in.nextLine();
		
		while(!userExists(username)) {
			System.out.println("No account found associated with username entered. Please enter a different username.");
			username = in.nextLine();
			if (userExists(username)) 
				break;
			continue;
			}
		
		System.out.println("Enter password associated with username : " + username);
		String password = in.nextLine();
		while (!correctPassword(username, password)) {
			System.out.println("Incorrect password. Please enter a different password. You must've mispelled it or something - I know your exist :) ");
			password = in.nextLine();
			if (correctPassword(username, password)) 
				break;
			continue;
		}
		/* will set current user to the returned value
		 * method also prints info of this user to prevent necessity to enter for loop again or construct Array object within this method just to print temporarily useful information
	     */
	    curUser = accountType(username, password);
		System.out.println("====================");
		return true;
	}

	private static boolean userExists(String userName) {
		for (Account i : accounts) {
			if (i.getUsername().equals(userName))
				return true;
		}
		return false;
	}
	private static boolean correctPassword(String username, String password) {
		for (Account i : accounts) {
			if (i.getUsername().equalsIgnoreCase(username)) {
				if (i.getPassword().equalsIgnoreCase(password)) 
					return true;
				return false;
			}
		}
		return false;
	}
	private static UserType accountType (String username, String password) {
		for (Account i : accounts) {
			if (i.getUsername().equalsIgnoreCase(username) 
					&& i.getPassword().equalsIgnoreCase(password)) {
				i.printInformation();
				return i.getType();
			}
		}
		return null;
	}
	/** private static boolean createAccountMenu()
	 *  Inputs information for account creation
	 * @return boolean to continue through main menu
	 */
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
		
		System.out.println("Please enter account type:");
		UserType type = UserType.valueOf(in.next()); 
		
		database.addUserAccount(firstName, lastName, username, password, email, type);
		
		System.out.println("\nNow returning to Main Menu...");
		return true;
	}
	
	/** private static void showAccountDatabase()
	 * Helper method to test AccountDatabase when needed
	 */
	private static void showAccountDatabase() {
		AccountDatabase database = AccountDatabase.getDatabase();
		ArrayList<UserAccount> accounts = database.getAccounts();
		
		for(UserAccount account: accounts) {
			account.printInformation();
		}
	}
	
	/** private static boolean accountOptions()
	 * Menu options for Admin accounts
	 * @return boolean to continue looping through main menu
	 */
	private static boolean accountOptions() {
		boolean rep = true;
		while(rep) {
			System.out.println("====================");
			System.out.println("1. Add event");
			System.out.println("2. Remove event");
			System.out.println("-1. Back to Main");
			System.out.println("====================");
			try {
			rep = accSwitch(in.nextInt());
			} catch(Exception e) {
				in.next();
			}
		}
		return true;
	}
	
	/** private static boolean accSwitch(int choice)
	 * Directors for menu choices in AccountOptions()
	 * @param choice
	 * @return
	 */
	private static boolean accSwitch(int choice) {
		switch(choice) {
		case -1:
			return false;
		case 1:
			addMovie();
			return false;
		case 2:
			removeMovie();
			return false;
		default:
			return true;
		}
	}
	
	/** private static void removeMovie()
	 * Admin user can remove Event from the list
	 */
	private static void removeMovie() {
		System.out.println("Please enter event name:");
		String eventName = in.next();
		int index = -1;
		for(Event e : events) {
			if(e.getTitle().equals(eventName)) {
				index = events.indexOf(e);
			}
		}
		if(index == -1) {
			System.out.println("Error, event not found");
			return;
		}
		events.remove(index);
		System.out.println("Successfully removed " + eventName);
	}
	
	/** private static void addMovie()
	 * Admin user can add Event to the list
	 */
	private static void addMovie() {
		System.out.println("Please enter event name:");
		String eventName = in.next();
		
		System.out.println("Please enter event description:");
		String eventDescription = in.next();
		
		System.out.println("Please enter any actors, when finished enter -1:");
		boolean rep = true;
		ArrayList<Actor> actors = new ArrayList<Actor>();
		while(rep) {
			try {
				if(in.hasNextInt()) {
					if(in.nextInt() == -1) {
						rep = false;
						continue;
					}
				}
				String[] actor = in.next().split(" ");
				actors.add(new Actor(actor[0], actor[1]));
			} catch(Exception e) {
				in.next();
			}
		}
		System.out.println("Please enter any genres, when finished enter -1:");
		rep = true;
		ArrayList<Genre> genres = new ArrayList<Genre>();
		while(rep) {
			try {
				if(in.hasNextInt()) {
					if(in.nextInt() == -1) {
						rep = false;
						continue;
					}
				}
				genres.add(Genre.valueOf(in.next()));
			} catch(Exception e) {
				System.out.println("Invalid entry");
				in.next();
			}
		}
		
		System.out.println("Please enter event advisory:");
		Advisory ad = null;
		rep = true;
		while(rep) {
			try {
				ad = Advisory.valueOf(in.next());
				rep = false;
			} catch(Exception e) {
				System.out.println("Invalid entry");
				in.next();
			}
		}
		
		System.out.println("Please enter event type:");
		rep = true;
		EventType eType = null;
		while(rep) {
			try {
				eType = EventType.valueOf(in.next());
				rep = false;
			} catch(Exception e) {
				System.out.println("Invalid entry");
				in.next();
			}
		}
		
		System.out.println("Please enter event point value:");
		int points = in.nextInt();
		
		System.out.println("Please enter event price:");
		double price = in.nextDouble();
		
		System.out.println("Please enter hour of event showtime:");
		int t = in.nextInt();
		Time time = new Time(t, 0, 0);
		
		events.add(new Event(eType, eventName, eventDescription, actors, genres, ad, price, points, time));
	}
}



