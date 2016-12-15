package SeriesProblems;

public class WaterOrHistogramSeries {
	/**
	 * two pointer series
	 * @author Xuechao
	 *
	 */
	class WaterContainer {
		public int waterContainer (int[] lines) {
			if (lines == null || lines.length < 2) return 0;
			int ret = 0;
			//O(n^2) time
			for (int i = 0; i < lines.length; i++) {
				for (int j = i; j < lines.length; j++) {
					int height = Math.min(lines[i], lines[j]);
					ret = Math.max(height*(j-i), ret); 
				}
			}
			return ret;
		}
		
		
		public int waterContainer_TwoPointer (int[] lines) {
			/**
			 * from both end. To increase the result, because the width is the largest, you must increase height. Thus we abandon the smaller one.
			 */
			
			int result = 0;
			int start = 0;
			int end = lines.length-1;
			while (start < end) {
				int height = Math.min(lines[start], lines[end]);
				result = Math.max(result, (end-start)*height);
				if (lines[start] <= lines[end]) {
					start++;
				} else {
					end--;
				}
			}
			return result;
		}
	}
}
