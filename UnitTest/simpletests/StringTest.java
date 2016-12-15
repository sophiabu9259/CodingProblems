package simpletests;

import org.junit.Test;

public class StringTest {

	@Test
	public void test() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(-1);
		System.out.println(sb.toString());
	}

}
