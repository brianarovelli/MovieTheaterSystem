import java.util.ArrayList;


public class AccountDatabase {
	private static AccountDatabase accountDatabase = null;
	private static ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
	
	private AccountDatabase() {
		accountList = AccountsLoader.loadAccounts();
	}
	
	/** public static AccountDatabase getDatabase()
	 * Creates instance of AccountDatabase
	 * @return
	 */
	public static AccountDatabase getDatabase() {
		if(accountDatabase == null) {
			accountDatabase = new AccountDatabase();
		}
		return accountDatabase;
	}
	
	/** public ArrayList<UserAccount> getAccounts()
	 * Return list of UserAccounts
	 * @return
	 */
	public ArrayList<UserAccount> getAccounts() {
		return accountList;
	}
	
	/** public void addUserAccount(String firstName, String lastName, String username, String password, String email, UserType type)
	 * Creates UserAccount and adds to list
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param type
	 */
	public void addUserAccount(String firstName, String lastName, String username, String password, String email, UserType type) {
		accountList.add(new UserAccount(firstName, lastName, username, password, email, type));
		AccountWriter.saveAccounts();
	}
}
