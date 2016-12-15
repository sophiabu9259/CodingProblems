package DivideAndConquer;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareRootTest {
	
	SquareRoot mySR = new SquareRoot();
	@Test
	public void testSqrt() {
		assertEquals(2, mySR.sqrt(4));
		assertEquals(2, mySR.sqrt(7));
		assertEquals(0, mySR.sqrt(0));
		assertEquals(1, mySR.sqrt(1));
		assertEquals(100, mySR.sqrt(10001));
	}

}
