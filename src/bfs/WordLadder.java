package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength (String startWord, String endWord, Set<String> wordList) {
		int ret = 0;
		Queue<String> queue = new LinkedList<>();
		queue.add(startWord);
		
		if (wordList.contains(startWord) && wordList.contains(endWord) ) {
			return 0;
		}
		
		while (!queue.isEmpty()){
			String word = queue.poll();
			char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char temp = arr[0];
					
					for (char c = 'a'; c <= 'z'; c++) {
						arr[0] = c;
						String test = arr.toString();
						if (wordList.contains(test)){
							wordList.remove(test);
							queue.add(test);
						}
					}
					arr[0] = temp;
			}
			ret ++;
		}
		return ret;
	}
}
