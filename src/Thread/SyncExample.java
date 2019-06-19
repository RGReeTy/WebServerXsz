package Thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

import main.LinkedList;

public class SyncExample {

	private List<String> list = new LinkedList<>();
	private int count = 0;

	public synchronized void addString(String s) {
		count++;
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add(s);
	}

	public synchronized String getString() {
		if (count > 0) {
			count--;
			return list.remove(0);
		} else {
			return null;
		}

	}

}
