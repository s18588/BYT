
import java.io.*;

public class Client1 {

	public static void printPerson(Writer out, Person person) throws IOException {
		out.write(person.lastName);
		out.write(" ");
		if (person.middleName != null) {
			out.write(person.middleName);
			out.write(" ");
		}
		out.write(person.firstName);
	}

}
