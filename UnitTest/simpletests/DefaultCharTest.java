package simpletests;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultCharTest {

	@Test
	public void test() {
		char[] test = new char[1];
		assertEquals(test[0], '\u0000');
	}

}
