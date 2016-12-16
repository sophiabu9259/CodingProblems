package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
* initialize the board with give rows, cols and mines
* implement the onClick() function
*/

public class MineSweeper {
	private int[][] board;
	private boolean[][] shown;
	private int rows;
	private int cols;
	private int mines;
	private int markedBlock;
	private long totalBlock;

	MineSweeper (int rows, int cols, int mines) {
		build (rows, cols, mines);
	}

	/**
	*	init board
	*	put the mines (randomed pos)
	*	get the indicators (traverse all the mines)
	*	
	*/

	public void build (int rows, int cols,int mines) {
		this.rows = rows;
		this.cols = cols;
		this.mines = mines;
		this.board = new int[rows][cols];
		this.shown = new boolean[rows][cols];
		this.totalBlock = rows * cols;
		
		if (mines > rows * cols) return;

		Random rand = new Random();

		while (mines-- > 0) {
			int[] pos = {0, 0};
			pos[0] = rand.nextInt (rows);
			pos[1] = rand.nextInt (cols);
			if (this.board[pos[0]][pos[1]] == -1) mines++;
			else {
				this.board[pos[0]][pos[1]] = -1;
			}
		}

		//calculate the numbsers
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (this.board[i][j] == -1) {

					//traverse neighbours
					for (int p = i - 1; p <= i + 1; p++) {
						for (int q = j - 1; q <= j +1; q++) {
							boolean valid = p >= 0 && q >= 0 && p < rows && q < cols;
							boolean notIJ = !(p == i && q == j);
							if (valid && notIJ && this.board[p][q] != -1) {
								this.board[p][q]++;
							}
						}
					}

				}
			}
		}


	}
	// 2 for win, 1 for continue, 0 invalid input, -1 for lose
	public int click (int row, int col) {
		if (row < 0 || col < 0 || row > this.rows - 1 || col > this.cols - 1) {
			return 0;
		}

		if (this.shown[row][col]) return 0;
		if (this.board[row][col] == -1) {
			printAll();
			return -1;
		}
		// TODO: test for win and return 2 on winning, wait to implement, not asked this time

		//check not zero
		if (this.board[row][col] > 0) {
			this.markedBlock++;
			this.shown[row][col] = true;
		}

		//shown the area from the clicked spot
		if (this.board[row][col] == 0) {
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{row, col});
			this.shown[row][col] = true;
			this.markedBlock++;

			while (!queue.isEmpty()) {
				int[] top = queue.poll();

				for (int i = top[0] - 1; i <= top[0] + 1; ++i) {
					for (int j = top[1] -1 ; j <= top[1] + 1; ++j) {
						if (i >= 0 && j >= 0 && i < this.rows && j < this.cols && !this.shown[i][j]) {
							if (this.board[i][j] == 0) {
								queue.offer(new int[] {i, j});
							}
							this.shown[i][j] = true;
							this.markedBlock++;
						}
					}
				}
			}
		}
		
		print();
		if (this.markedBlock == this.totalBlock - this.mines) return 2;
		else System.out.println("Total "+ this.totalBlock + " Shown: "+ this.markedBlock + " Mines : " + this.mines);
		return 1;
	}

	public void print () {
		for (int i = 0; i < this.rows; ++i) {
			for (int j = 0; j < this.cols; ++j) {
				System.out.print(this.shown[i][j] ? (this.board[i][j] == -1 ? "X" : this.board[i][j] ): "-");		
			}
			System.out.println();
		}
	}
	
	public void printAll () {
		for (int i = 0; i < this.rows; ++i) {
			for (int j = 0; j < this.cols; ++j) {
				System.out.print(this.board[i][j] == -1 ? "X" : this.board[i][j]);		
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args) {
		
		MineSweeper m = new MineSweeper(10, 10, 5);
		
		Scanner s = new Scanner (System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		if (x == 100) {
			m.printAll();
		}
		int result = m.click(x, y);
		
		while (result != -1 && result != 2) {
			x = s.nextInt();
			y = s.nextInt();
			result = m.click(x,y);
		}
		
		System.out.println(result == -1 ? "you lost" :"you winn!");
		s.close();
	}

}
