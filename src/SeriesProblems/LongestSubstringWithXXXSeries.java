package SeriesProblems;

public class LongestSubstringWithXXXSeries {
	static class UniqueK {
		int unique2substring (String input) {
			int[] cmap = new int[128];
			char[] arr = input.toCharArray();
			int counter = 0;
			int slow = 0;
			int fast = 0;
			int max = 0;
			
			while (fast < input.length()) {
					if (cmap[arr[fast++]]++ == 0) {
						counter++;
					}
				
					while (counter > 2) {
						if (cmap[arr[slow++]] -- == 1) {
							counter --;
						}
					}
					
					if (counter == 2) {
						max = Math.max(fast - slow, max);
					}
			}
			
			return max;
		}
		
		int uniqueKsubstring (String input, int k) {
			int[] cmap = new int[128];
			char[] arr = input.toCharArray();
			int counter = 0;
			int slow = 0;
			int fast = 0;
			int max = 0;
			
			while (fast < input.length()) {
					if (cmap[arr[fast++]]++ == 0) {
						counter++;
					}
				
					while (counter > k) {
						if (cmap[arr[slow++]] -- == 1) {
							counter --;
						}
					}
					
					if (counter == k) {
						max = Math.max(fast - slow, max);
					}
			}
			
			return max;
		}
	}
	
	public static void main (String[] args) {
		UniqueK myu2 = new UniqueK();
		String input = "abcbcabcbbbca";
		System.out.println("Test U2, result 6 " + myu2.unique2substring(input));
		System.out.println("Test UK, 2, result 6 " + myu2.uniqueKsubstring(input, 2));
		System.out.println("Test UK, 3, result 13 " + myu2.uniqueKsubstring(input, 3));
		
	}
}
