package SeriesProblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class BFS_DFS_UNIONFINDTest {
	
	BFS_DFS_UNIONFIND_261 t = new BFS_DFS_UNIONFIND_261();

	@Test
	public void testValidTree() {
		
		int[][] test = {{0,1}, {0,2}, {1,2}, {2,3}, {2,4}};
		
		assertFalse(t.validTree(3, test));
		
	}

}
