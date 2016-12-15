package backtracking;

import org.junit.Test;
import java.util.List;
public class GenerateParenthesisTest {
	GenerateParenthesis myGP = new GenerateParenthesis();
	@Test
	public void testGenerateParenthesis() {
		List<String> ret = myGP.generateParenthesis(3);
		for (String s : ret) {
			System.out.println(s);
		}
	}

}
