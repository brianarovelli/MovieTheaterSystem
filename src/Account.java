import java.util.Scanner;

public class Account {
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected String email;
	protected UserType type;
	
	/** public Account()
	 * Default constructor
	 */
	public Account() {
		this.firstName = null;
		this.lastName = null;
		this.username = null;
		this.password = null;
		this.type = null;
	}
	
	/** public Account(String firstName, String lastName, String username, String password, String email, UserType type)
	 * Paramaterized constructor
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param type
	 */
	public Account(String firstName, String lastName, String username, String password, String email, UserType type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	/** public void printPassword()
	 * Prints Password in safe asterick form
	 */
	public void printPassword() {
		/* Prints password out in "*" format */
		int length = this.password.length();
		System.out.print("Password: ");
		for(int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	/** public void changePassword()
	 * Option to change User's password
	 */
	public void changePassword() {
		/* Option to change an existing users password */
		Scanner in = new Scanner(System.in);
		System.out.println("PLEASE ENTER OLD PASSWORD");
		String oldpassword = in.next();
		if(oldpassword.equals(this.password)) {
			System.out.println("PLEASE ENTER NEW PASSWORD");
			this.password = in.next();
			System.out.println("THANK YOU. YOUR PASSWORD HAS BEEN CHANGED");
		}
		System.out.println("SORRY. YOUR PASSWORD COULD NOT BE CHANGED");
		in.close();
	}

	/** public void printInformation()
	 * Prints account information
	 */
	public void printInformation() {
		/* Shows existing users their account information */
		System.out.println("ACCOUNT DETAILS");
		System.out.println("====================");
		System.out.println("First name: " + this.firstName);
		System.out.println("Last name: " + this.lastName);
		System.out.println("username: " + this.username);
		printPassword();
		System.out.println("Email: " + this.email);
		System.out.println("User Type: " + this.type);
		System.out.println("====================");
		
	}
	
	/* GETTERS AND SETTERS */
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserType getType() {
		return type;
	}
	
	public void setType(UserType type) {
		this.type = type;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
