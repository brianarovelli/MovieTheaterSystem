import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AccountLoader extends AccountConstants {
	
	public static ArrayList<UserAccount> loadAccounts() {
		ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
		
		try {
			System.out.println("VIBES 1");
			FileReader reader = new FileReader(ACCOUNTS_FILE);
			JSONParser parser = new JSONParser();
			JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
			
			System.out.println("VIBES 2");
			for(int i = 0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				String firstName = accountJSON.get(ACCOUNT_FIRST_NAME).toString();
				String lastName = accountJSON.get(ACCOUNT_LAST_NAME).toString();
				String username = accountJSON.get(ACCOUNT_USERNAME).toString();
				String password = accountJSON.get(ACCOUNT_PASSWORD).toString();
				String email = accountJSON.get(ACCOUNT_EMAIL).toString();
				UserType type = UserType.valueOf(accountJSON.get(ACCOUNT_TYPE).toString());
				accounts.add(new UserAccount(firstName, lastName, username, password, email, type));
			}
			
			return accounts;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
