package dynamicprogramming;
/**
 * first straightforward: use i as boundary and divide and conquer
 * then found there are recalculated subproblems: max of [0,i] is the larger one of [0,i-1] and prices[i] - min
 * case 1: xxxx 1(min) xxxx 9(pre max) 0 (prices[i]) - > fit 
 * case 2: xxxx 1(min) xxxx 9(pre max) 8 (prices[i]) - > fit 
 * case 3: xxxx 1(min) xxxx 9(pre max) 10(prices[i]) -> fit
 * similarly, do this for the righter half (from i to end)
 * @author Xuechao
 *
 */
public class StockIII {
	public int maxProfitTwoTrans (int[] prices) {
		int ret = 0;
		//edge cases
		
		 //second start date choices amount: price.length
		/*
		 * O(n^2) runtime, bad
		 */
		/*for (int i = 0; i < prices.length; ++i) {
			int firstProfit = 0;
			int min = 0;
			for (int j = 0; j <=i; ++j) {
				min = Math.min(min, prices[j]);
				firstProfit = Math.max(firstProfit, prices[j]-min);
			}
			int secondProfit = 0;
			min = 0;
			for (int j = i; j < prices.length; ++j) {
				min = Math.min(min, prices[j]);
				secondProfit = Math.max(secondProfit,  prices[j]-min);
			}
			
			ret = Math.max(ret, firstProfit + secondProfit );
		}*/
		
		int[] profolio = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; ++i) {
			min = Math.min(min, prices[i]);
			profolio[i] = Math.max(profolio[i-1], prices[i] - min);
		}
		int max = prices[prices.length-1];
		int[] profolio2 = new int[prices.length];
		for (int i = prices.length - 2; i >= 0; --i) {
			max = Math.max(max, prices[i]);
			profolio2[i] = Math.max(profolio2[i+1], max - prices[i]);
		}
		
		for (int i = 0; i < prices.length; ++i) {
			ret = Math.max(profolio[i]+profolio2[i], ret);
		}
		
		return ret;
	}
}
