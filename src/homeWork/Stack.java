package homeWork;

public class Stack<T> extends DataStructure<T> {
	
	public Stack() {
		super(new DynaArray<T>());
	}
	
	public Stack(DynaArray<T> dataSet) {
		super(dataSet);
	}
	
	@Override
	public	final int getCurrentIndex() {
		return size()-1;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected T[] toArray() {
		T[] array = (T[]) new Object[dataSet.size()];
		for (int i=0; i<dataSet.size(); i++) {
			array[i]=dataSet.get(dataSet.size()-1-i);
		}
		return array;
	}
	
}
