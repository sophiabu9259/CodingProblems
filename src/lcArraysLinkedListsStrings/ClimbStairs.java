package lcArraysLinkedListsStrings;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author Xuechao
 *
 */
public class ClimbStairs {
	
	static int[] fibonacci;
	public ClimbStairs(int n){
		int[] fibo = new int[n+1];
		fibo[0] = fibo[1] = 1;
		for(int i = 2; i <= n; i++){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		fibonacci = fibo;
	}
	public int climbStairs(int n) {
        /**
         * f(n) = f(n-1) + f(n-2)
         * But don't use recursion. Duplication of computations.
         * Use Fibonacci Array
         */
		return fibonacci[n];
    }
}
