package main;

public class StackNew extends DataStructure {

	public StackNew() {
		super(new DynaArray());
	}

	@Override
	public final int getCurrentIndex() {
		return size() - 1;
	}

	@Override
	protected Object[] toArray() {
		int[] array = new int[dataSet.size()];
		for (int i = 0; i < dataSet.size(); i++) {
			array[i] = (int) dataSet.get(dataSet.size() - 1 - i);
		}
		return null; //Object[];
	}

}
