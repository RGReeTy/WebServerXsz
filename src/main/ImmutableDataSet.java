package main;

import java.util.Arrays;

public final class ImmutableDataSet extends DataSet {
	private final DataSet originalDataSet;

	public ImmutableDataSet(DataSet originalDataSet) {
		super();
		this.originalDataSet = originalDataSet;
		this.size = originalDataSet.size();
	}

	public Object add(int index) {
		return originalDataSet.get(index);

	}

	@Override
	public Object remove(int index) {
		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public Object get(int index) {
		return originalDataSet.get(index);
	}

	@Override
	public Object[] toArray() {
		return originalDataSet.toArray();
	}

	@Override
	public String toString() {
		return originalDataSet.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return originalDataSet.equals(obj);
	}

	@Override
	public int hashCode() {
		return originalDataSet.hashCode();
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

}
