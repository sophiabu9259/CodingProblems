package interviewprep.indeed;

import java.util.Arrays;

public class OA5 {
	public void union (int[] parent, int i, int j) {
		int pi = find (parent, i);
		int pj = find (parent, j);
		parent[pi] = pj;
	}
	
	public static int find (int[] parent, int i) {
		if (i < parent.length) {
			if (parent[i] == -1 || parent[i] == i) {
				return i;
			}
			
			find (parent, parent[i]);
		}
		return -1;
	}
	
	public static int minModified (int[] input) {
		int[] parent = new int[input.length];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < input.length; ++i) {
			input[i] -= 1;
		}
		
		int result = 0;
		for (int e : input) {
			if (find (parent, e) != -1) {
				result ++;
			}
		}
		return result;
	}
	
	public static void main(String[] arg) {
	OA5 o = new OA5();
	int[] arr = {1,2,3,4,5};
	System.out.println(minModified(arr));
	}
}
