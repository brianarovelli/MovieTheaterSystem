import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
	
	@Test
	public void testAll() {
		printPassword();
		changePassword();
		printInformation();
		getFirstName();
		setFirstName();
		getLastName();
		setLastName();
		getUsername();
		setUsername();
		getPassword();
		setPassword();
		getType();
		setType();
		getEmail();
		setEmail();
	}

    @Test
    public void printPassword() {
    }

    @Test
    public void changePassword() {
    }

    @Test
    public void printInformation() {
    }

    @Test
    public void getFirstName() {
    }

    @Test
    public void setFirstName() {
        Account account = new Account();
        account.setFirstName("Joe");
        assertEquals("Joe", account.getFirstName());

    }

    @Test
    public void getLastName() {
    }

    @Test
    public void setLastName() {
        Account account = new Account();
        account.setLastName("Exotic");
        assertEquals("Exotic", account.getLastName());
    }

    @Test
    public void getUsername() {
    }

    @Test
    public void setUsername() {
        Account account = new Account();
        account.setUsername("JoeExotic12");
        assertEquals("JoeExotic12", account.getUsername());
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void setPassword() {
        Account account = new Account();
        account.setPassword("TigerKing");
        assertEquals("TigerKing", account.getPassword());
    }

    @Test
    public void getType() {
    }

    @Test
    public void setType() {
        Account account = new Account();
        account.setType(UserType.Guest);
        assertEquals("Guest", account.getType());
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
        Account account = new Account();
        account.setEmail("JoeExotic@TigerKing.com");
        assertEquals("Joe", account.getEmail());
    }
}