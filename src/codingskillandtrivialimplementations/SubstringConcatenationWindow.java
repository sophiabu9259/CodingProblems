package codingskillandtrivialimplementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * start from 0 to s.len - wCount * wLength, each time only run wCount times. Whenever failing
 * or success, break and do another.
 * @author Xuechao
 *
 */
public class SubstringConcatenationWindow {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return ret;
		}

		Map <String, Integer> frequency = new HashMap<>();
		for (String word: words) {
			if (frequency.containsKey(word)) {
				frequency.put (word, frequency.get(word) + 1);
			} else {
				frequency.put(word, 1);
			}
		}
		
		int wordLen = words[0].length();
		for (int i = 0; i <= s.length() - wordLen * words.length; ++i) {
			Map <String, Integer> temp = new HashMap<>(frequency);
			for (int j = 0; j < words.length; j++) {
				String segment = s.substring(i + j * wordLen, i + j * wordLen + wordLen);
				if (temp.containsKey(segment)) {
					if (temp.get(segment) < 0) {
						break;
					} else {
						temp.put(segment, temp.get(segment) - 1);
						if (temp.get(segment) == 0) {
							temp.remove(segment);
						}
						if (temp.isEmpty()) {
							ret.add(i);
							break;
						}
					}
				} else {
					break;
				}
			}
		}
		
		return ret;
	}
}
