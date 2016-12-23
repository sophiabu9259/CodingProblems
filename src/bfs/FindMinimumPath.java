package bfs;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class FindMinimumPath {
	public List<int[]> pathfinding (int[][] matrix, int[] start, int[] end) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || start == null || end == null || start.length != 2 || end.length != 2) return res;

		int row = matrix.length;
		int col = matrix[0].length;

		Queue<List<int[]>> q = new LinkedList<>();
		List<int[]> init = new ArrayList<>();
		init.add (start);
		
		q.offer(init);
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			List<int[]> list = q.poll();
			int[] top = list.get (list.size() - 1);
			if (Arrays.equals (top, end)) {
				//System.out.println("Found end");
				return list;
			}
			
			//System.out.println(Arrays.toString(top) + " != " +Arrays.toString(end) );
			
			int[][] dirs = {
				{1, 0}, {-1 ,0}, {0, 1}, {0, -1}
			};

			for (int[] dir : dirs) {
				int[] adjacent = {
					top[0] + dir[0], top[1] + dir[1]
				};

				if (adjacent[0] < 0 || adjacent [0] >= row || adjacent[1] < 0 || adjacent [1] >= col || matrix[adjacent[0]][adjacent[1]] == 0) continue; 

				if (!visited[adjacent[0]][adjacent[1]]) {
					List<int[]> temp = new ArrayList<> (list);
					temp.add(adjacent);
					q.offer(temp);
					visited[adjacent[0]][adjacent[1]] = true;
				}
			}
		}
		
		//System.out.println("Not Found end");
		return new ArrayList<int[]>();
	}
} 
