package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000, SEK));

		SweBank.deposit("Alice", new Money(10000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 1, 0, new Money(10_00, SEK), SweBank, "Alice");
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 100, 1, new Money(10000, SEK), SweBank, "Alice");
		testAccount.tick();
		assertEquals(20000, (int)SweBank.getBalance("Alice"));
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(1000, SEK));
		assertEquals(new Money(9000, SEK).getAmount(), testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(new Money( 10000, SEK).getAmount(), testAccount.getBalance().getAmount());
	}
}
