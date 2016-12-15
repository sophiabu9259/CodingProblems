package codingskillandtrivialimplementations;

import java.util.List;

import org.junit.Test;

public class SubstringConcatenationWindowTest {

	@Test
	public void test() {
		SubstringConcatenationWindow mySCW = new SubstringConcatenationWindow();
		String test = "aaaaaaaaaa";
		String[] dict = {
				"aa","aa"
		};
		
		List<Integer> ret = mySCW.findSubstring(test, dict);
		for (Integer i : ret) {
			System.out.print(" "+ i);
		}
	}

}


