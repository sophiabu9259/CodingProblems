package simpletests;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		BinarySearchMe myBS = new BinarySearchMe();
		int[] input = {
				0,1,2,4
		};
		System.out.println("-2" + myBS.binarySearch(input, -2));
		System.out.println("5" + myBS.binarySearch(input, 5));
		System.out.println("3 not found but should be " + myBS.binarySearch(input, 3));
		System.out.println("4" + myBS.binarySearch(input, 4));
	}

}
