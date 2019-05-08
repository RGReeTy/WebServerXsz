package main;
// class doesn't used anywhere, just for LULZ
public class Item<I> {
	private Item<I> next;
	private I value;
	private Item<I> previous;
	
	Item(I value){
		this.value = value;
	}
	Item<I> getNext() {
		return next;
	}
	void setNext(Item<I> next) {
		this.next = next;
	}
	I getValue() {
		return value;
	}
	public void setValue(I value) {
		this.value = value;
	}
	Item<I> getPrevious() {
		return previous;
	}
	void setPrevious(Item<I> previous) {
		this.previous = previous;
	}

}
