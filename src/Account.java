import java.util.Scanner;

public abstract class Account {
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected String email;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

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
	
	public void changePassword() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
