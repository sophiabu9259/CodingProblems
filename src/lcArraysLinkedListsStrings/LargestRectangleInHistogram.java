package lcArraysLinkedListsStrings;

import java.util.Stack;
/**
 * Find rightedge and leftedge. Use stack use avoid double direction dectection.
 * @author Xuechao
 *
 */
public class LargestRectangleInHistogram {
	/**
	 * Core problem: find a range for each bar such that in this range, the bar is the smallest bar.
	 * Approach: naive way: from each bar, stretch indices in both directions until meet ends or meet a smaller bar.
	 * 			 tricky way: maintain a stack containing only increasing or equal bars. Whenever you meet a smaller one height[i], that is 
	 * 			 the right edge of the range you what. Left edge is the bar under the stack top, because all the bars on the left of second top are smaller or equal to this
	 *           top guy, and all the bars between top and second top are larger than top. Pop and calculate such top bars until the top of the stack is smaller or equal to height[i]. If you pop the equal one,
	 *           left range is correct, but right edge could be larger than i. So keep equal or smaller ones.
	 *           If i reaches the end of array and stack is not empty, end of array is the right edge for all the bars inside the stack. Left edge is itself.
	 * 			 If the bar is the only one inside the stack, left edge should be 0.
	 * @param height
	 * @return
	 */
	public int largestRectangleArea(int[] height) {
		if ( height == null || height.length == 0) {
			return 0;
		}
		
		int result = 0;
		int leftEdge = 0;
		int rightEdge = 0;
		int area = 0;
		int smallestBarIndex = 0;
		
		Stack<Integer> ranger = new Stack<Integer>();
		int index = 0;
		
		while (index < height.length) {
			if (ranger.isEmpty()) {
				ranger.push(index++);
			} else {
				if (height[index] >= height[ranger.peek()]) {
					ranger.push(index++);
				} else {
					smallestBarIndex = ranger.pop();
					leftEdge = ranger.isEmpty()? 0 : ranger.peek()+1;
					rightEdge = index;
					area = height[smallestBarIndex] * (rightEdge - leftEdge);
					result = Math.max(result, area);
				}
			}
		}
		
		rightEdge = index;
		while (!ranger.isEmpty()) {
			smallestBarIndex = ranger.pop();
			leftEdge = ranger.isEmpty()? 0 : ranger.peek()+1;
			area = height[smallestBarIndex] * (rightEdge - leftEdge);
			result = Math.max(result, area);
		}
		
		return result;
	}
}
