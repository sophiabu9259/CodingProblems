package simpletests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HashSetTest {

	@Test
	public void test() {
		/**
		 * test: contains int[]
		 * result : even they have same elements, set  cannot detect it.
		 */
		
		Set<Integer[]> set = new HashSet<>();
		Integer[] a = {1,2};
		set.add(a);
		Integer[] b = {1,2};
		Integer[] c = {2,1};
		System.out.println(set.contains(b));
		System.out.println(set.contains(c));
	}

}
