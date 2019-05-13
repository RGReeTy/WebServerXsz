package Exceptions;

public class SomeUsefulExamples {

	public static void main(String[] args) {
		System.out.println(ret());

	}

	private static int ret() {
		try {
			return 0;
		} finally {
			return 1; // Do not use "finally" llike return function
		}
	}
}
