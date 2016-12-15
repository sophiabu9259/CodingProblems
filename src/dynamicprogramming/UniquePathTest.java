package dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePathTest {

	UniquePath myUP = new UniquePath();
	
	@Test
	public void testUniquePaths() {
		assertEquals("m = 3, n = 6", 21, myUP.uniquePaths(3, 6));
	}

}
