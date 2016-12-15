package bfs;


import org.junit.Test;

public class GoProcesserTest {
	
	GoProcesser myGo = new GoProcesser();

	@Test
	public void testDetectAndFlip_0() {
		char[][] board = {
				{'O', 'O'},
				{'O', 'O'}
		};
		myGo.detectAndFlip(board);
		print(board);		
	}
	
	@Test
	public void testDetectAndFlip_1() {
		char[][] board = {
				{'O', 'X', 'O'},
				{'X', 'O', 'X'},
				{'X', 'X', 'X'}
		};
		myGo.detectAndFlip(board);
		print(board);		
	}
	
	@Test
	public void testDetectAndFlip_2() {
		char[][] board = {
				{'O', 'X', 'O'},
				{'X', 'O', 'X'},
				{'X', 'O', 'X'}
		};
		myGo.detectAndFlip(board);
		print(board);		
	}
	
	@Test
	public void testDetectAndFlip_3() {
		char[][] board = {
				{'O', 'X', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'X', 'X', 'O'}
		};
		myGo.detectAndFlip(board);
		print(board);		
	}
	
	@Test
	public void testDetectAndFlip_4() {
		char[][] board = {
				{'X', 'X', 'X', 'O', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'O', 'X', 'O', 'O'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'O'},
				{'X', 'X', 'X', 'X', 'O', 'X', 'O'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'O'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'O', 'X', 'X', 'O', 'O', 'O', 'X'},
		};
		myGo.detectAndFlip(board);
		print(board);		
	}
	
	public void print (char[][] board) {
		for (char[] s : board) {
			for (char c : s ) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

}
