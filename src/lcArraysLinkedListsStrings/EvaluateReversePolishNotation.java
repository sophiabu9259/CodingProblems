package lcArraysLinkedListsStrings;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	/**
	 * 
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
        Stack<Integer> mstack = new Stack<>();
        for (String s : tokens) {
        	if (s.length() == 0) {
        		continue;
        	}
        	int value = 0;
        	try {
        		value = Integer.valueOf(s);
        		mstack.push(value);
        	} catch (Exception e) {
        		int a = 0;
        		int b = 0;
        		if (!mstack.isEmpty()) {
        			b = mstack.pop();
        		}  else {
        			continue;
        		}
        		
        		if (!mstack.isEmpty()) {
        			a = mstack.pop();
        		} else {
        			continue;
        		}
        		int result = 0;
        		char c = s.charAt(0);
        		if (c == '+') result = a + b;
        		else if (c == '-') result = a - b;
        		else if (c == '*') result = a * b;
        		else result = a / b;
        		mstack.push(result);
        	} 
        }
        
        return mstack.pop();
    }
}
