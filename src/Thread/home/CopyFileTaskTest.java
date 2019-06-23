package Thread.home;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyFileTaskTest {

	public static void main(String[] args) throws IOException {
		Task copyFileTask = new CopyFileTaskExecutorService(Paths.get("test/large.txt"), Paths.get("test/large-copy.txt"));
		copyFileTask.start();
		System.out.println("Started");
		while (true) {
			String cmd = new Scanner(System.in).nextLine();
			if("i".equalsIgnoreCase(cmd)) {
				copyFileTask.interrupt();
				System.out.println("Interrupted: "+copyFileTask.getPercentProgress()+" %");
				break;
			} else if ("p".equalsIgnoreCase(cmd)) {
				System.out.println("Current progress: "+copyFileTask.getPercentProgress()+" %");
			} else if ("q".equalsIgnoreCase(cmd)) {
				break;
			}
		}

	}

}
