package codingskillandtrivialimplementations;
/**
 * notice 10, 100, 1000. Use a number to record reverse right side until mid point.
 * @author Xuechao
 *
 */
public class isPalindromeNumber {
	public boolean isPalindrome(int x) {
		int base = 0;
		int xShadow = x;
		if (x%10 == 0) return x == 0;
		while (xShadow > base) {
			base = base * 10 + xShadow%10;
			xShadow/=10;
		}

		return base == xShadow || base/10 == xShadow;
	}
}
