import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AccountWriter extends AccountConstants {
	
	public static void saveAccounts() {
		AccountDatabase database = AccountDatabase.getDatabase();
		ArrayList<UserAccount> accounts = database.getAccounts();
		JSONArray jsonAccounts = new JSONArray();
		
		/* Create all the JSON objects */
		for(int i = 0; i < accounts.size(); i++) {
			jsonAccounts.add(getAccountJSON(accounts.get(i)));
		}
		
		/* Write the JSON File */
		try(FileWriter file = new FileWriter(ACCOUNTS_FILE)) {
			file.write(jsonAccounts.toJSONString());
			file.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static Object getAccountJSON(UserAccount account) {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(ACCOUNT_FIRST_NAME, account.getFirstName());
		accountDetails.put(ACCOUNT_LAST_NAME, account.getLastName());
		accountDetails.put(ACCOUNT_USERNAME, account.getUsername());
		accountDetails.put(ACCOUNT_PASSWORD, account.getPassword());
		accountDetails.put(ACCOUNT_EMAIL, account.getEmail());
		accountDetails.put(ACCOUNT_TYPE, account.getType());
		return accountDetails;
	}
}
