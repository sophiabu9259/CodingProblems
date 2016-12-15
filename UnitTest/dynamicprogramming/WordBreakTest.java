package dynamicprogramming;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordBreakTest {
	
	

	@Test
	public void testWordBreak() {
		Set<String> dict = new HashSet<>();
		dict.add("aaa");
		dict.add("aaaa");
		WordBreak myWB = new WordBreak();
		assertTrue (myWB.wordBreak("aaaaaaa", dict));
	}

}
