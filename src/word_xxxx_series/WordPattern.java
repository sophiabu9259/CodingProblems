package word_xxxx_series;

import java.util.HashMap;
import java.util.Map;

public class WordPattern{
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        if (pattern == null || str == null) return pattern == str;
        String[] words = pattern.split (" ");
        char[] arr = str.toCharArray();
        for (int i = 0; i < words.length; ++i) {
            if (!map.containsKey(arr[i])) {
                map.put (arr[i], words[i]);
            }
            
            if (! map.get (arr[i]).equals (words[i]) ) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean wordPatternMatchII (String pattern, String str) {
		String[] map = new String[26];
		boolean res = backtracking (map, pattern, 0, str, 0);
		return res;
	}

	private boolean backtracking (String[] map, String pattern, int p, String str, int q) {
		if (p == pattern.length() && q == str.length()) {
			return true;
		}

		//index of pattern and str
		if (p >= pattern.length()) return false;
		int pChar = (int) pattern.charAt(p) - 'a';

		if (map[pChar] == null) {
			for (int end = q + 1; end <= str.length(); ++end) {
				String tryPattern = str.substring (q, end);
				
				boolean dupValue = false;
				for (String s : map) {
					if (s != null && s.equals (tryPattern) ) {
						dupValue = true;
						break;
					}
				}
				if (dupValue) continue;
				
				map[pChar] = tryPattern;
				if (backtracking (map, pattern, p + 1, str, end)) return true;
			}
			map[pChar] = null;
			return false;
		}
		
		String correct = map[pChar];
		if (q + correct.length() <= str.length() && correct.equals(str.substring(q, q + correct.length())) && backtracking (map, pattern, p + 1, str, q + map[pChar].length())) return true;
		return false;
	}
}
