package b_Money;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@BeforeEach
	public void setUp() throws AccountExistsException, AccountDoesNotExistException {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());

	}

	@Test
	public void testGetCurrency() {
		assertEquals("DKK",DanskeBank.getCurrency().getName());
		assertEquals("SEK",SweBank.getCurrency().getName());
		assertEquals("SEK",Nordea.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		try {
			Nordea.openAccount("Ulrika");
		} catch (AccountExistsException e) {
			fail("Adding account shouldn't fail");
		}
		try {
			SweBank.openAccount("Bob");
		} catch (AccountExistsException e) {
			return;
		}
		fail("Adding account BOB shoudl fail because it already exists");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(100, SEK));
		assertEquals((int)SweBank.getBalance("Ulrika"), 100);

	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Ulrika", new Money(100, SEK));
		assertEquals((int)SweBank.getBalance("Ulrika"), -100);
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException, AccountExistsException {
		testDeposit();
		setUp();
		testWithdraw();
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.transfer("Bob", DanskeBank,"Gertrud", new Money(100_00, SEK));
		assertEquals((int)SweBank.getBalance("Bob"), -100_00);
		assertEquals((int)DanskeBank.getBalance("Gertrud"), 75_00);
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob", "pay1",
				100, 0, new Money(100_00, SEK), SweBank, "Ulrika");
		SweBank.tick();
		assertEquals((int)SweBank.getBalance("Bob"), -100_00);
		assertEquals((int)SweBank.getBalance("Ulrika"), 100_00);
	}
}
