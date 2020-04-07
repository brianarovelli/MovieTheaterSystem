import java.util.ArrayList;

public class AccountDatabase {
	private static AccountDatabase accountDatabase = null;
	private static ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
	
	private AccountDatabase() {
		accountList = AccountLoader.loadAccounts();
	}
	
	public static AccountDatabase getDatabase() {
		if(accountDatabase == null) {
			accountDatabase = new AccountDatabase();
		}
		return accountDatabase;
	}
	
	public ArrayList<UserAccount> getAccounts() {
		return accountList;
	}
	
	public void addUserAccount(String firstName, String lastName, String username, String password, String email, UserType type) {
		accountList.add(new UserAccount(firstName, lastName, username, password, email, type));
		AccountWriter.saveAccounts();
	}
}
