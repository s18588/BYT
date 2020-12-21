
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		Client1.printPerson(out, bobSmith);
		assertEquals("Bob Smith", out.toString());

		out = new StringWriter();
		Client1.printPerson(out, jennyJJones);
		assertEquals("Jenny J Jones", out.toString());

		assertEquals("Smith, Bob", Client2.formatPerson(bobSmith));
		assertEquals("Jones, Jenny J", Client2.formatPerson(jennyJJones));

		out = new StringWriter();
		Client3.display(out, bobSmith);
		assertEquals("Smith, Bob", out.toString());

		out = new StringWriter();
		Client3.display(out, jennyJJones);
		assertEquals("Jones, Jenny J", out.toString());

		assertEquals("Smith, Bob", Client4.toString(bobSmith));
		assertEquals("Jones, Jenny J", Client4.toString(jennyJJones));
	}
}
