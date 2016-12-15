package codingskillandtrivialimplementations;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		int[] map = new int[128];
		char[] arrT = t.toCharArray();
		for (char c : arrT) {
			map[c]++;
		}

		int start = 0;
		int end = 0;
		int minSize = Integer.MAX_VALUE;
		int retHead = 0;
		int counter = arrT.length;

		while (end < s.length()) {
			if (map[s.charAt(end)] > 0) {
				counter--;
			}
			map[s.charAt(end++)]--;

			while (counter == 0) {
				int tempSize = end - start; // end is not "real" end of the window. end was incremented after counting its char. 
				if (tempSize < minSize) {
					retHead = start;
					minSize = tempSize;
				}
				if (map[s.charAt(start++)]++ == 0) {
					counter++;
				}
			}
		}
		return minSize < Integer.MAX_VALUE? s.substring(retHead, retHead + minSize) : "";
	}
}
