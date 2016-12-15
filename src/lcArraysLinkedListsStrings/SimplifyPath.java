package lcArraysLinkedListsStrings;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath (String path) {
		Stack<String> record = new Stack<>();
		for (String e : path.split("/")) {
			boolean skip = e.equals("") || e.equals(".");
			if (skip) {
				continue;
			}
			
			if (e.equals("..") && !record.isEmpty()) {
				record.pop();
			} 
			
			if (!e.equals("..")) {
				record.push(e);
			}
		}
		
		StringBuilder myStrB = new StringBuilder("");
		for (String e : record) {
			myStrB.append("/"+e);
		}
		return myStrB.length() == 0? "/" : myStrB.toString();
	}
}
