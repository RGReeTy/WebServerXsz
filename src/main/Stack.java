package main;

public class Stack {
	private DynaArray list = new DynaArray();

	public void add(int element) {
		list.add(element);

	}

	public Object get() {
		return list.remove(list.size() - 1);
	}

	public int size() {
		return list.size();
	}
}
