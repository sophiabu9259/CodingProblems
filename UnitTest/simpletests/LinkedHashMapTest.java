package simpletests;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

@SuppressWarnings("unused")
public class LinkedHashMapTest {

	@Test
	public void test() {
		Map<Integer, Integer> test = new LinkedHashMap<>();
		test.put(1,1);
		test.put(2,2);
		test.put(3,3);
		
		for (Entry<Integer, Integer> entry : test.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

}
