package stack;

import java.util.Stack;

public class RemoveKDigits {     
    public String removeKdigits(String num, int k) {
        if (num == null) return null;
		Stack<Character> s = new Stack<>();
        //delete the number bigger than its successor, so that a smaller number would take its place.
        //remember to use a smaller element to pop all its larger predecessors, not only one
		int i = 0;
		while (i < num.length()) {
			char ch = num.charAt(i);
			if (k > 0) {
				if (s.isEmpty()) {
					s.push (ch);
					i++;
				} else {
					char top = s.peek();
					if (top > ch) {
						s.pop();
						k--;
					} else {
						s.push(ch);
						i++;
					}
					
				}
			} else break;
		}
        
        //if the number is an ascending sequence, delete backwards until length is out or k is out
		while (k > 0 && !s.isEmpty()) {
		        s.pop();
		        k--;
	    }
	    
	    // reconstruct the remaining string and get rid of starting 0s
		StringBuilder sb = new StringBuilder (num.substring(i));
		while (!s.isEmpty()) {
			sb.insert (0, s.pop());
		}
		i = 0;
		while (i < sb.length() && sb.charAt(i) == '0') {
			i++;
		}
         
        //if (sb has nothing) return 0 else return the non-0-starting sequence
		return i == sb.length()? "0" : sb.substring(i);
    } 

}
