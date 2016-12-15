package backtracking;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {
	WordSearch myWS = new WordSearch();
	@Test
	public void testExist_1() {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		assertTrue ("SEE is included", myWS.exist(board, "SEE"));
	}
	
	@Test
	public void testExist_2() {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		
		assertTrue ("ABCCEDF is included", myWS.exist(board, "ABCCEDF"));
	}
	
	@Test
	public void testExist_3() {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		assertTrue ("ABCESEECFDAS is included", myWS.exist(board, "ABCESEECFDAS"));
	}
	
	@Test
	public void testExist_4() {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		assertFalse ("ABFDFBA is included, but invalid", myWS.exist(board, "ABFDFBA"));
	}
	
	@Test
	public void testExist_5() {
		char[][] board = {
				{'A'},
				};
		assertTrue ("A is included", myWS.exist(board, "A"));
	}
}
