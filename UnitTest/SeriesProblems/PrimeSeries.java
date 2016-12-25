package SeriesProblems;

import java.util.Arrays;

public class PrimeSeries {
	
	int x = 0;
	
	public boolean isPrime (int n) {
		for (int i = 2; i < n/2; ++i) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill (isPrime, true);
		int res = 0;
		for (int i = 2; i < n; ++i) {
			if (!isPrime[i]) continue;
			res ++;
			for (int j = 2; j * i < n; ++j) {
				isPrime[j * i] = false;
			}
		}

		return res;
    }

    public double myPowIter(double x, int n) {
    	double res = 1;
    	long m = Math.abs ((long)n);
    	while (m > 0) {
    		if (m % 2 == 1) res *= x;
    		x *= x;
    		m /= 2;
    	}

    	return n > 0? res : 1/res;
    }

    public double myPow(double x, int n) {
        long m = n;
    	if (n == 0) return 1;
    	if (n < 0) {
    		x = 1/x;
    		m = - m;
    	}
    	return helper (x, m);
    }

    public double helper (double x, long n) {
    	double factor = n % 2 == 0? 1 : x;
    	if (n == 1) return x;
    	return factor * helper (x * x, n/2);
    }

    public int sqrt (int n) {
if ( n == 0 || n == 1) return n;
		
		int lo = 1;
		int hi = n/2 + 1;
		/* FOR ROUND UP USE THIS
		int minDist = Integer.MAX_VALUE;
		int min = 0;
		*/
		/* FOR ROUND DOWN USE THIS */
		int last = 0;
		
		while (lo < hi) {
		    int mid = lo + (hi - lo) / 2;
		    int sqTemp = n / mid;
		    if (sqTemp == mid) return mid;
		    
		    /* FOR ROUND UP USE THIS
		    if (Math.abs(n - sqTemp) < minDist) {
		            minDist = Math.abs(n - sqTemp);
		            min = mid;
		    }
		    */
		    
		    if (sqTemp < mid) {
		        hi = mid;
		    } else {
		        lo = mid + 1;
		        last = mid;
		    }
		}
		
		return last;
    }
    
}
