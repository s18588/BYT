public class Person {
	public String lastName;

	public String firstName;

	public String middleName;

	public Person(String firstName, String lastName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		if (getMiddleName() != null)
			return getFirstName() + ", " + getLastName() + " " + getMiddleName();
		return getFirstName() + ", " + getLastName();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
}