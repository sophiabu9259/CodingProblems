package dynamicprogramming;

import java.util.Stack;
/**
 * rightedge is peek + 1.
 * @author Xuechao
 *
 */
public class MaximumRectangle {
	
	public int maximalRectangle_DP(char[][] matrix) {
		if (matrix == null || matrix[0].length == 0) {
			return 0;
		}
		
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		
		int[] height = new int[rowLen];
		int[] leftEdge = new int[colLen]; // indicates the left edge of  this col's consecutive 1's sequence.
		int[] rightEdge = new int[rowLen];
		
		int ret = 0;
		
		for (int i = 0; i < rowLen; ++i) {
			int leftPossibleStart = 0;
			int rightPossibleEnd = colLen;
			//record the highest height and its left edge for each element in the matrix.
			//select the larger one of uppser left edge and lower left edge
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					leftEdge[j] = Math.max(leftEdge[j], leftPossibleStart);
				} else {
					height[j] = 0;
					leftEdge[j] = 0; // in case the number right below this 0 is 1 and belong to a lefter edge.
									// make sure the left edge is not updated by the '0' position with max function.
					rightEdge[j] = 0;
					leftPossibleStart = j + 1;
				}
			}
			
			for (int j = colLen-1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					rightEdge[j] = Math.min(rightEdge[j], rightPossibleEnd);
					ret = Math.max(ret, height[j]* (rightEdge[j]- leftEdge[j]));
				} else {
					rightPossibleEnd = j; // not j-1 because we want 11110  leftstart is the first 1. rightend is the rightmost first 0. so posOf(0) - posOf(left first1) would give us the width of 4
				}
			}
		}
		return ret;
		
	}
	
	public int maximalRectangle(char[][] matrix) {
		   int row = matrix.length;
		   int col = matrix[0].length;
		   int[][] f = new int[matrix.length][matrix[0].length];
		   int[] maxRecRow = new int[row];

		   for (int i = 0; i < col; i++) {
		     f[0][i] = matrix[0][i] - '0';
		   }
		   maxRecRow[0] = findOneRow (f[0]);
		   for (int i = 1; i < row; i++) {
		      for (int j = 0; j < col; ++j) {
		         f[i][j] = f[i-1][j] != 0 && matrix[i][j] != '0' ? f[i-1][j] + 1 : matrix[i][j] - '0';
		      }
		      maxRecRow[i] = findOneRow (f[i]);
		   }
		   int max = 0;
		   for (int i = 0; i < row ; i++) {
		      max = Math.max(max, maxRecRow[i]);
		   }
		   return max;    
	}
	
	private int findOneRow (int[] ant) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(ant[0]);
		
		int i = 0;
		for (i = 1; i < ant.length; ++i) {
			if (ant[i] >= ant[stack.peek()]) {
				stack.push(i);
			} else {
				while (ant[stack.peek()] > ant[i] && !stack.isEmpty()) {
					int top = stack.pop();
					int leftEdge = stack.isEmpty()? 0 : stack.peek()+1;
					max = Math.max(max, (i - leftEdge) * ant[top]);
				}
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
				int top = stack.pop();
				int leftEdge = stack.isEmpty()? 0 : stack.peek()+1;
				max = Math.max(max, (i - leftEdge) * ant[top]);		
		}
		
		return max;
	}
}
