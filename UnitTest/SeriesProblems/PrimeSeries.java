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
    	return 0;
    }
    
}
