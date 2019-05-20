package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> emptyList = Collections.emptyList();
		Iterator<String> emptyIterator = Collections.emptyIterator();

		final List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] { 9, 3, 4, 2, 1, 5, 7, 6, 8 }));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		list.clear();
		List<Integer> unmodif = Collections.unmodifiableList(list);
		try {
			unmodif.clear();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}

		list.addAll(Arrays.asList(new Integer[] { 9, 3, 4, 2, 1, 5, 7, 6, 8 }));
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);

		List<String> singletonList = Collections.singletonList("Hello World!");
		System.out.println(singletonList);

		Collections.fill(list, 0);
		System.out.println(list);
	}

}
