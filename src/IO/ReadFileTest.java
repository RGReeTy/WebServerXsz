package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

public class ReadFileTest {

	public static void main(String[] args) throws IOException {
		readLines1();
		readLines2();
		readLines3();
		readLines4();
		readLines5();
		readLines11();
	}

	private static void readLines1() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("text-file.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	private static void readLines2() throws IOException {
		StringWriter wr = new StringWriter();
		char[] cbuf = new char[8192];
		try (Reader r = new FileReader("text-file.txt")) {
			while (true) {
				int read = r.read(cbuf);
				if (read == -1) {
					break;
				}
				wr.write(cbuf, 0, read);
			}
		}
		System.out.println(wr.toString());
	}

	private static void readLines3() throws IOException {
		StringBuilder res = new StringBuilder();
		char[] cbuf = new char[8192];
		try (Reader r = new FileReader("text-file.txt")) {
			while (true) {
				int read = r.read(cbuf);
				if (read == -1) {
					break;
				}
				res.append(cbuf, 0, read);
			}
		}
		System.out.println(res.toString());
	}

	private static void readLines4() throws IOException {
		StringBuilder res = new StringBuilder();
		try (Reader r = new FileReader("text-file.txt")) {
			while (true) {
				int symbol = r.read();
				if (symbol == -1) {
					break;
				}
				res.append((char) symbol);
			}
		}
		System.out.println(res.toString());
	}

	private static void readLines5() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("text-file.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void readLines11() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("text-file.txt"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

}
