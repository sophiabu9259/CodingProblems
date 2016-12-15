package SeriesProblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stock1Test {

	@Test
	public void test() {
		StockSeries myS1 = new StockSeries();
		int[] test = {
				7,1,5,3,6,4
		};
		assertEquals(4,myS1.maxProfit1(test));
	}

}
