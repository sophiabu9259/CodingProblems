package simpletests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
	public static void main (String[] args) {
		Map<List<String>, Integer> testMap = new HashMap<>();
		String[] arr1 = {"Jo", "He", "Le"};
		String[] arr2 = {"Jo", "He", "Le"};
		List<String> list1 = new ArrayList<String>(Arrays.asList(arr1));
		List<String> list2 = new ArrayList<String>(Arrays.asList(arr2));
		
		testMap.put(list1, 1);
		System.out.println(testMap.containsKey(list1));
		
	}
}
