package DivideAndConquer;

public class Pow {
	public double pow (double x, int n) {
		return n < 0 ? 1.0/helper(x,-n) : helper(x,n); 
	}
	
	private double helper (double x, int n) {
		if (n == 0) return 1.0;
		if (n == 1) return x;
		return helper(x, n/2) * helper(x, n/2) * helper (x, n%2);
	}
}
