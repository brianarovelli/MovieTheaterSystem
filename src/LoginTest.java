import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
class LoginTest {

	@Test
	void test() {
		ArrayList <UserAccount> list;
		list = testLoader();
		if (list == null) 
				System.out.println("Failed to generate list.");
		else {
			assertSame(list.size(), 4);
			for (UserAccount i : list) {
				if (i.getUsername().equals("marysue")) {
					String username = i.getUsername();
					String password = i.getPassword();
					assertSame(password, "123");
					// if this returns true, methods in driver associated with loginMenu should all work properly
					}
			}
	}
		
}

	public ArrayList testLoader() {
			return new ArrayList <UserAccount>(AccountsLoader.loadAccounts());
	
	}
	

}
