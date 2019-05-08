package main;

import java.util.Arrays;

public class DataStructure {
	protected final DataSet dataSet;

	public DataStructure(DataSet dataSet) {
		super();
		this.dataSet = dataSet;
	}

	public void add(int element) {// add elem to collection
		dataSet.add(element);
	}

	public int getCurrentIndex() { // delete and return current elem
		return 0;
	}

	public int get() { // delete and return current elem
		return (int) dataSet.remove(getCurrentIndex());
	}

	public int peek() {// return current elem without deleting
		return (int) dataSet.get(getCurrentIndex());
	}

	public int size() {// size of collection
		return dataSet.size();
	}

	public boolean isEmpty() { // true if collection are ffree
		return size() == 0;
	}

	protected Object[] toArray() {
		return dataSet.toArray();
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(toArray());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DataStructure other = (DataStructure) obj;
		if (!Arrays.equals(toArray(), other.toArray())) {
			return false;
		}
		return true;
	}

}
