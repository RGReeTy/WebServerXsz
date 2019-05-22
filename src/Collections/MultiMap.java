package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public interface MultiMap<K, V> {
	int size();

	boolean isEmpty();

	boolean containsKey(K key);

	boolean containsValue(V value);

	void clear();

	void put(K key, V value);

	void put(Map<K, V> map);

	int countValues(K key);

	Collection<V> get(K key);

	Iterator<V> remove(K key);

	Set<K> keySet();

	Set<Map.Entry<K, Collection<V>>> entrySet();

	Collection<V> values();

	Iterator<V> valuesIterator(K key);
}
