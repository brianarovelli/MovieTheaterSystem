import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AccountsLoader extends AccountConstants {
	/**
	 * Loads accounts from json
	 * @param path Path to file
	 * @return ArrayList of accounts
	 */
	public static ArrayList<UserAccount> loadAccounts() {
		try {
			//Load JSON file
			FileReader reader = new FileReader(ACCOUNTS_FILE);
			JSONArray accountJSON = (JSONArray)new JSONParser().parse(reader);
			//Create ArrayList to be filled with file's elements
			ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
			//Cycle through array of JSON Objects
			for(int i = 0; i < accountJSON.size(); i++) {
				JSONObject accountsJSON = (JSONObject)accountJSON.get(i);
				//Get parameters for accounts from JSON
				String lastName = accountsJSON.get(ACCOUNT_LAST_NAME).toString();
				String firstName = accountsJSON.get(ACCOUNT_FIRST_NAME).toString();
				String userName = accountsJSON.get(ACCOUNT_USERNAME).toString();
				String password = accountsJSON.get(ACCOUNT_PASSWORD).toString();
				String email = accountsJSON.get(ACCOUNT_EMAIL).toString();
				UserType type = UserType.valueOf(accountsJSON.get(ACCOUNT_TYPE).toString());
				accounts.add(new UserAccount(firstName,lastName,userName,password,email,type));
			}
			return accounts;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}



