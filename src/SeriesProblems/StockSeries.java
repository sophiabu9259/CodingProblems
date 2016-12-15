package SeriesProblems;
/**
 * Non-greedy method first.
 * @author Xuechao
 *
 */
public class StockSeries {
	/**
	 * keep track of min value and update max diff.
	 * @param prices
	 * @return
	 */
	public int maxProfit1 (int[] prices) {
		int maxProfit = 0;
		int ret = prices[0];
		for (int e : prices) {
			maxProfit = Math.max(maxProfit, e-ret);
			if ( e < ret ) ret = e;
		}
		return maxProfit;
		
	}
	
	public int maxProfit2(int[] prices)	 {
		if (prices == null || prices.length < 2) return 0;
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				maxProfit += (prices[i] - prices[i-1]);
			}
		}
		return maxProfit;
	}
	
	public int maxProfit2_NoneGreedy (int[] prices) {
		int localMin = 0;
		int i = 0;
		int maxProfi = 0;
		
		while (i < prices.length) {
			while (i < prices.length && prices[i] >= prices[i+1]) {
				i++;
			}
			localMin = prices[i];
			while (i < prices.length-1 && prices[i + 1] >= prices[i]) {
				i++;
			}
			maxProfi += (prices[i] - localMin);
			i++;
		}
		return maxProfi;
	}
}
