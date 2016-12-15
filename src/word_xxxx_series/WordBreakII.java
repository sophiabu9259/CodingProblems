package word_xxxx_series;
import java.util.*;

public class WordBreakII {
	public static void main (String[] args) {
		Set<String> dict = new HashSet<>();
		String[] arr = {
				"cat", "cats", "and", "sand", "dog"
		};
		dict.addAll( new ArrayList<> (Arrays.asList(arr)));
		
		String input = "catsanddog";
		
		System.out.println(wordBreakDP(input, dict));
	}
	
	public static List<String> wordBreak (String input, Set<String> dict) {
		List<String> ret = new ArrayList<>();
		backtracking (input, dict, 0, new StringBuilder(), ret);
		return ret;
	}
	
	public static void backtracking (String input, Set<String> dict, int start, StringBuilder temp, List<String> ret) {
		if (start == input.length()) {
			ret.add(new String(temp.toString()));
		} else {
			for (int i = start + 1; i <= input.length(); ++i) {
				String part = input.substring(start, i);
				if (dict.contains(part)) {
					if (temp.length() == 0) {
						temp.append(part);
					}
					else {
						temp.append(" " + part);
					}
					backtracking(input, dict, i, temp, ret);
					if (temp.length() == part.length()) {
						temp.delete(0, temp.length());
					}
					else {
						temp.delete(temp.length() - part.length() - 1, temp.length());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> wordBreakDP (String input, Set<String> dict) {
		List<String> ret = new ArrayList<>();
		Set<Integer>[] checklist = new Set[input.length() + 1];
		/*
		 * initialize the dp list.
		 * for first set, add 0 to start.
		 */
		for (int i = 0; i < checklist.length; ++i) {
			checklist[i] = new HashSet<>();
		}
		checklist[0].add(0);
		
		for (int i = 0; i < input.length() + 1; ++i) {
			if (checklist[i].isEmpty()) continue;
			
			for (String word : dict) {
				if (i + word.length() <= input.length()) {
					if (word.equals(input.substring(i, i + word.length()))) {
						checklist[i + word.length()].add(word.length());
					}
				}
			}
		}
		
		if (checklist[input.length()].isEmpty()) return ret;
		
		backtrackingDP (checklist,input, input.length(), new StringBuilder(), ret);
		
		return ret;
	}
	
	private static void backtrackingDP (Set<Integer>[] checklist, String input, int start, StringBuilder temp, List<String> ret) {
		if (start == 0) {
			ret.add(new String(temp.toString()));
		} else {
			for (int e : checklist[start]) {
				if (temp.length() == 0) {
					temp.append(input.substring(start - e ,start));	
				} else {
					temp.insert(0, input.substring(start - e, start) + " ");
				}
				
				backtrackingDP (checklist, input, start - e, temp, ret);

				if (temp.length() == e) {
					temp.delete(0, e);
				} else {
					temp.delete(0, e + 1);
				}
			}
		}
	}
}
