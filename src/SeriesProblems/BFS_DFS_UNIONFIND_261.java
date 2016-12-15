package SeriesProblems;

import java.util.Arrays;

public class BFS_DFS_UNIONFIND_261 {
	public boolean validTree(int n, int[][] edges) {
        //bfs or dfs need record two directions. and must delete them all once visited
        int[] roots = new int[n];
        for (int i = 0; i < n; ++i) {
            roots[i] = i;
        }
        
        for (int[] e : edges) {
            Arrays.sort(e);
            if (find (roots, e[0]) != find(roots,e[1]) ) {
                roots[e[1]] = find (roots, e[0]);
            } else {
            	return false;
            }
        }
    
        
        return edges.length == n - 1;
        
        
    }
    
    private int find (int[] roots, int cur) {
        while (roots[cur] != cur) {
            roots[cur] = roots[roots[cur]];
            cur = roots[cur];
        }
        return cur;
    }
}
