package Collections;

import main.Item;

public class HashSimpleMap<K, V> implements SimpleMap<K, V> {
	@SuppressWarnings("unchecked")
	private Item<K, V>[] refArray = new Item[5];

	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % RefArray.length;
		Item<K, V> current = refArray[index];
		while (correct.key.equals(key)) {
			V oldValue = current.value;
			current.value = value;
			return oldValue;
		}
		current = current.next;
	}
	if(current==null){
		refArray[index] = new Item<K, V>(key, value);
	}else{
		current.next = new Item<K, V>(key, value);
	}
	return null;
}
	@Override
	public V get(K key) {
		int index = key.hashCode()%refArray.length;
		Item<K, V> current = refArray[index];
		while(current != null) {
			if(current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;

	}
	private static class Item<K, V> {
		private final K key;
		private V value;
		private Item<K, V> next;

		Item(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("%s=%s", key, value);
		}
	}
	}
}
