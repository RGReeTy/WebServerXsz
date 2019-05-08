package homeWork;


public class Queue<T> extends DataStructure<T> {
	
	public Queue() {
		super(new LinkedList<T>());
	}

	public Queue(LinkedList<T> dataSet) {
		super(dataSet);
	}
	@Override
	public int getCurrentIndex() {
		return 0;
	}
	

}
