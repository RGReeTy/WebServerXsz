package Interfaces;

import main.Student;
/*	Main task of this programm - 
 * is calculating of avg age of students.
 */
public class StudentCalculator {
	public static void main(String[] args) {
		StudentProvider studentProvider = new TestStudentProvider();
		Student[] students = studentProvider.getStudents();
		int ageSum = 0;
		for (Student student : students) {
			ageSum += student.getAge();
		}
		System.out.println("Result: " + ageSum / students.length);
	}

}
