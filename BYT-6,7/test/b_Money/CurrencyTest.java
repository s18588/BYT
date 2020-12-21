package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}

	@Test
	public void testGetRate() {
		assertEquals(new Double(0.15), SEK.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.11);
		assertEquals(new Double(0.11), SEK.getRate());
	}
	
	@Test
	public void testUniversalValue() {
		assertEquals(15, (int)SEK.universalValue(100));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(533, (int)DKK.valueInThisCurrency(400, SEK));
		assertEquals(53, (int)DKK.valueInThisCurrency(400, EUR));

	}

}
