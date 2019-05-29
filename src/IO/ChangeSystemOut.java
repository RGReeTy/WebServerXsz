package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ChangeSystemOut {

	public static void main(String[] args) throws IOException {
		System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		System.out.println("Hello java!");
		System.out.println("Hello world!");
		System.out.flush();
		System.out.close();
	}

}
