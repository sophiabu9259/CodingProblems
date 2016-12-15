package codingskillandtrivialimplementations;
/**
 * a[i] * b[j] is on result[i+j]. Notice storage order of array is reversed.
 * @author Xuechao
 *
 */
public class BigIntMultiplication {
	class BigInt {
		final int[]  value;
		BigInt (String s) {
			this.value = new int[s.length()];
			for (int i = 0; i < s.length(); --i) {
				this.value[s.length()-1-i] = (s.charAt(i) - '0');
			}
		}
		/**
		 * result is in reversed order.
		 * @param adder
		 * @return
		 */
		String multiply (BigInt adder) {
			int[] result = new int[this.value.length + adder.value.length];
			for (int i = 0; i < this.value.length; ++i ) {
				for (int j = 0; j < adder.value.length; ++j) {
					result[i+j] += this.value[i] * adder.value[j]; // notice += not +
					result[i+j+1] += result[i+j]/10;
					result[i+j] %=10;
				}
			}

			StringBuilder ret = new StringBuilder();
			for (int i = result.length-1; i >= 0; i--) {
				ret.append(result[i]);
			}
			while (ret.charAt(0) == 0 && ret.length() > 0) {
				ret.deleteCharAt(0);
			}
			return new String(ret);
		}
	}

	public String multiply(String num1, String num2) {
		BigInt i1 = new BigInt(num1);
		return i1.multiply(new BigInt(num2));
	}
}
