package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import lcArraysLinkedListsStrings.GroupAnagrams;

@SuppressWarnings("unused")
public class GroupAnagramTest {
	
	GroupAnagrams myGA = new GroupAnagrams();
	@Test
	public void test() {
		String[] test = {
				"eat", "tea", "tan", "ate", "nat", "bat" ,"bait", "tab", "tant", "tnat"
		};
		
		List<List<String>> temp = myGA.groupAnagrams(test);
		for (List<String> i:temp){
			for (String j:i){
				System.out.print(j+", ");
			}
			System.out.print("\n");
		}
	}

}
