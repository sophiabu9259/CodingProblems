package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/**
 * Wrapper previous node to construct the result tree. Clear same level visited nodes before next level. Use minLevel to record the result level.
 * @author xuechao
 *
 */
public class WordLadder2 {
	
	class Wrapper {
		String word;
		int level;
		Wrapper pre;
		Wrapper (String word, int level, Wrapper pre) {
			this.word = word;
			this.level = level;
			this.pre = pre;
		}
	}
	
	private List<String> backtrace (Wrapper leaf) {
		List<String> ret = new LinkedList<>();
		ret.add(leaf.word);
		Wrapper runner = leaf;
		while (runner.pre != null) {
			ret.add(0, runner.pre.word);
			runner = runner.pre;
		}
		return ret;
	}
	
	public List<List<String>> findLadders (String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ret = new ArrayList<>();
		Queue<Wrapper> queue = new LinkedList<>();
		queue.add(new Wrapper(beginWord, 1, null));
		wordList.add(endWord);
		
		Set<String> visited = new HashSet<>();
		int breakLevel = -1;
		
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				Wrapper alpha = queue.poll();
				if (alpha.word.equals(endWord)) {
					breakLevel = alpha.level;
				}
				if (alpha.level == breakLevel) {
					ret.add(backtrace(alpha));
					continue;
				}
				// not end, go transform
				char[] arr = alpha.word.toCharArray();
				for (int j = 0; j < alpha.word.length(); j++) {
					char temp = arr[j];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (temp != ch) {
							arr[i] = ch;
							String check = new String(arr);
							if (wordList.contains(check)) {
								queue.add(new Wrapper(check, alpha.level+1, alpha));
								visited.add(check);
							}
						}
					}
					arr[j] = temp;
				}
 				
			}
			wordList.removeAll(visited);
		}
		return ret;	
	}	
}
