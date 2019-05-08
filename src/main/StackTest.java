package main;

public class StackTest {

	public static void main(String[] args) {
		Stack s = new Stack();
		for (int i = 0; i < 5; i++) {
			s.add(i);
		}
		while (s.size() > 0) {
			System.out.println(s.get() + " ");
		}
		System.out.println();

	}

}
