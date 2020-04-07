
public class UserAccount extends Account {
	public UserAccount() {
		super();
	}
	
	public UserAccount(String firstName, String lastName, String username, String password, String email, UserType type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}
}