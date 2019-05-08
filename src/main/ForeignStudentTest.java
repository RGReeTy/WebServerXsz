package main;

public class ForeignStudentTest {

	public static void main(String[] args) {
		Student s = new ForeignStudent("Jackie", "Chan", 60, "chinese");
		System.out.println(s.getFullName());

	}

}
