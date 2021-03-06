package Exceptions;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynaArray<E> extends DataSet<E> {
	private E[] array;

	public DynaArray() {
		array = (E[]) new Object[10];
	}

	public DynaArray(E[] array) {
		super();
		this.array = array;
		this.size = array.length;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		if (size == array.length) {
			E[] temp = array;

			array = (E[]) new Object[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				array[i] = temp[i];
			}
		}
		array[size++] = element;
	}

	public E get(int index) {
		if (index >= 0 && index < size()) {
			return array[index];
		} else {
			throw new IndexOutOfBoundsException("Index should be between 0 and "+(size()-1)+". Index to get: "+index);

		}
	}

	@Override
	public void clear() {
		super.clear();
		array = (E[]) new Object[10];
	}

	public E[] toArray() {
		return Arrays.copyOf(array, size);
	}


	public E remove(int index) {
		if (index >= 0 && index < size) {
			E value = array[index];
			for (int i = index; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
			array[--size] = null;
			return value;
		}

		throw new IndexOutOfBoundsException("Index should be between 0 and "+(size()-1)+". Index to remove: "+index);
	}

}