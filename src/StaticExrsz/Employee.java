package StaticExrsz;

public class Employee {
	private static int counter = 1;
	private final int number;
	private String firstName;
	private String lastName;

	public Employee(String firstName, String lastName) {
		super();
		this.number = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee() {
		super();
		this.number = counter++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getNumber() {
		return number;
	}
}
