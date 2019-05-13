package Exceptions;

public class TryCatch1Example {

	public static void main(String[] args) {
		try {
			int a =2;
			int b =0;
			int c = a/b;
			int[] arr = null;
			System.out.println(arr[1]);
			System.out.println(c);

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally");
		}

	}

}
