package main;

public class Queue {
	private LinkedList list = new LinkedList();

	public void add(int element) {
		list.add(element);
	}

	public Object get() {
		return list.remove(0);
	}

	public int size() {
		return list.size();
	}

}
