package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis (int n) {
		List<String> ret = new ArrayList<>();
		backtracking(ret, new StringBuilder("("), n-1, n);
		return ret;
	}
	
	private void backtracking (List<String> ret, StringBuilder temp, int leftRemaining, int rightRemaining) {
		if ( leftRemaining == 0 && rightRemaining == 0) {
			ret.add(temp.toString());
		} else {
			if (leftRemaining > 0) {
				temp.append('(');
				backtracking(ret, temp, leftRemaining-1, rightRemaining);
				temp.deleteCharAt(temp.length()-1);
			}
			
			if (rightRemaining > 0 && rightRemaining != leftRemaining) {
				temp.append(')');
				backtracking(ret, temp, leftRemaining, rightRemaining-1);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}
}
