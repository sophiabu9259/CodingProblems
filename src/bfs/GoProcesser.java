package bfs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
/**
 * better mark all boarder 'O' s first.
 * @author xuechao
 *
 */
public class GoProcesser {
	public void detectAndFlip (char[][] board) {
		//edge cases
		Queue<Integer[]> q = new LinkedList<>();
		Set<Integer[]> set = new HashSet<>();
		int rowlen = board.length;
		int collen = board[0].length;
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(!visited[i][j] && board[i][j] == 'O') {
					boolean abandon = false; // notice only can be modified once
					Integer[] pos = {i,j};
					q.offer(pos);
					set.add(pos);
					visited[i][j] = true;
					while (!q.isEmpty()) {
						Integer[] top = q.poll();
						if (abandon == false) {
							abandon =  (top[0] == 0 || top[0] == rowlen-1 || top[1] == 0 || top[1] == collen-1);
						}
						Integer[][] neighbours = {
								{top[0]-1, top[1]},
								{top[0]+1, top[1]},
								{top[0], top[1]-1},
								{top[0], top[1]+1}
						};
						
						for (Integer[] e : neighbours) {
							if (e[0] >= 0 && e[1] >=0 && e[0] < rowlen && e[1] < collen) {
								if (board[e[0]][e[1]] == 'O' && !visited[e[0]][e[1]]) {
									q.offer(e);
									set.add(e);
								} 
								visited[e[0]][e[1]] = true;
							}
						}
					}
					
					if(!abandon) {
						for (Integer[] e : set) {
							board[e[0]][e[1]] = 'X';
						}
					}
					set.clear();
				}
			}
		}
		
	}
}
