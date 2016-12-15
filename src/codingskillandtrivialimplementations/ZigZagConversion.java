package codingskillandtrivialimplementations;
/**
 * use many rows of stringbuilder to similuate zigzaging. then combine them together.
 * @author Xuechao
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0) {
			return "";
		}
		StringBuilder[] builders = new StringBuilder[numRows];
		for (int i = 0; i < numRows; ++i) {
			builders[i] = new StringBuilder();
		}

		int strPos = 0;
		int rowPos = 0;
		while (strPos < s.length()) {
			for (rowPos = 0; rowPos < numRows  && strPos < s.length() ; rowPos++) {
				builders[rowPos].append(s.charAt(strPos++));
			}
			for (rowPos = numRows -2 ; rowPos > 0 && strPos < s.length(); rowPos--) {
				builders[rowPos].append(s.charAt(strPos++));
			}
		}

		for (int i = 1; i < numRows; ++i) {
			builders[0].append(builders[i]);
		}
		return builders[0].toString();
	}
	
}
