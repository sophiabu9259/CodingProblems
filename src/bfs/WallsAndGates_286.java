package bfs;
import java.util.*;

public class WallsAndGates_286 {
	/**
	 * 1. from doors, update rooms on finding smaller path
	 * 2. matrix tip: directions array check bound
	 * 3. visited update on pushing into Queue
	 * 4. use Qsize as level to indicate path length
	 * @author Xuechao
	 *
	 */
	class Solution {
	    public void wallsAndGates(int[][] rooms) {
	        for (int i = 0; i < rooms.length; ++i) {
	            for (int j = 0; j < rooms[0].length; ++j) {
	                if (rooms[i][j] == 0) {
	                    bfs (rooms, i, j);
	                }
	            }
	        }
	    }
	    
	    void bfs (int[][] rooms,int a,int b) {
	        Queue<int[]> q = new LinkedList<>();
	        int[] start = {a, b};
	        q.offer(start);
	        
	        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
	        visited[a][b] = true;
	        
	        int[][] directions = {
	            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
	        };
	        
	        int level = 1;
	        while (!q.isEmpty()) {
	            int num = q.size();
	            for (int i = 0; i < num; ++i) {
	                int[] top = q.poll();
	                int x = top[0];
	                int y = top[1];
	                
	                for (int[] dir : directions) {
	                    int newX = x + dir[0];
	                    int newY = y + dir[1];
	                    
	                    if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length) {
	                        if (visited[newX][newY] || !isRoom(rooms[newX][newY])) continue;
	                        rooms[newX][newY] = Math.min (rooms[newX][newY], level); 
	                        visited[newX][newY] = true;
	                        int[] temp = {newX, newY};
	                        q.offer(temp);
	                    }
	                 }
	                
	                
	                
	            }
	            level++;
	        }
	    }
	    
	    boolean isRoom (int e) {
	        return !isDoor(e) && !isWall(e);
	    }
	    
	    boolean isDoor (int e) {
	        return e == 0;
	    }
	    
	    boolean isWall (int e) {
	        return e == -1;
	    }
	 }
}
