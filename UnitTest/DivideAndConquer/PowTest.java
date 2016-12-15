package DivideAndConquer;

import org.junit.Test;

public class PowTest {
	Pow myP = new Pow();
	@Test
	public void test() {
		System.out.println(myP.pow(1.2, 2));
		System.out.println(myP.pow(0.25,2));
		System.out.println(myP.pow(0.00001,Integer.MAX_VALUE));
	}

}
