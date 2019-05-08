package main;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setFirstName("Constantine");
		s1.setLastName("RGReetY");
		s1.setAge(28);
		System.out.println(s1.getFullName()+", "+s1.getAge());
	}

}
