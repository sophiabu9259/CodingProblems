package codingskillandtrivialimplementations;
/**
 * Notice sign, overflow. Use %10 and *10 + remainders.
 * @author Xuechao
 *
 */
public class ReverseIntegerSeries {
	public int reverse(int x) {
		int sign = x < 0? -1 : 1;
		int base = 0;
		int xShadow = Math.abs(x);

		while (xShadow > 0) {
			if (base > (Integer.MAX_VALUE- xShadow%10)/10 ) {
				return 0;
			}
			base = base * 10 + xShadow%10;
			xShadow/=10;
		}

		return base*sign;
	}
}
