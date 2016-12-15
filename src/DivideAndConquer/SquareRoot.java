package DivideAndConquer;

/**
 * Notice search starts from n/4. Only when mid^2 < n, mid could be a solution. Use n/mid to avoid overflow
 * @author xuechao
 *
 */
public class SquareRoot {
	public int sqrt(int n) {
if ( n == 0 || n == 1) return n;
		
		int lo = 1;
		int hi = n/2;
		int lastMid = 0;
		
		while (lo <= hi) {
			int mid = lo + (hi-lo)/2;
			
			if (n/mid > mid) {
				lo = mid + 1;
				lastMid = mid;
			} else if (n/mid < mid) { // this mid is not valid. Dont assign to lastmid
				hi = mid - 1;
			} else {
			    return mid;
			}
		}
		
		return lastMid;
	}
}


