package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIPAddress (String s) {
		List<String> ret = new ArrayList<String>();
		backtracking (ret, new ArrayList<String>(), s, 0);
		return ret;
	}
	
	private void backtracking (List<String> ret, List<String> temp, String s, int start) {
		if (temp.size() == 4 && start == s.length()) {
			StringBuilder myStrB = new StringBuilder(temp.get(0));
			for (int i = 1; i < 4; i ++){
				myStrB.append(".");
				myStrB.append(temp.get(i));
			}
			ret.add(myStrB.toString());
		} else if (temp.size() == 4 && start < s.length()) {
			return;
		} else {
			for (int i = start; i < s.length(); i++) {
				if (isIP(s, start,i)) {
					temp.add(s.substring(start, i+1));
					backtracking(ret, temp, s, i+1);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
	
	private boolean isIP (String s, int start, int end) {
		if (s.charAt(start) == '0' && start != end) return false;
		return Long.valueOf(s.substring(start, end+1)) < 256;
	}
}
