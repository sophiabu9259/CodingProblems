package bfs;

public class NumberOfIslands {
	//UNION FIND
	public int numIslands(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
		int row = matrix.length;
		int col = matrix[0].length;

		int[] roots = new int[row * col];
		for (int i = 0; i < roots.length; ++i) {
			roots[i] = i;
		}

		for (int j = 0; j < col; ++j) {
			for (int i = 0; i < row; ++i) {
			    if (matrix[i][j] == '0') continue;
				int top = -1;
				int left = -1;
				if (i != 0 && matrix[i-1][j] == '1') top = i - 1;
				if (j != 0 && matrix[i][j-1] == '1') left = j - 1;
				if (top == -1 && left == -1) continue;
				
				int index = i * col + j;
                //if only one of the adjacent is valid
				if (top == -1 || left == -1) {
				    int root = top == -1? index - 1 : index - col;
				    roots[index] = find (roots, root);
				    continue;
				}
				//if both valid, union them up
                roots[index] = find (roots, index - col);
                union (roots, roots[index], index - 1);

			}
		}

		int count = 0;
		for (int i = 0; i < roots.length; ++i) {
			if (roots[i] == i && matrix[i/col][i%col] == '1') {
			    System.out.println (count + ": " + i);
			    count++;
			}
		}
		return count;
	}

	public int find (int[] roots, int element) {
		int i = element;
		while (roots[i] != i) {
			roots[i] = roots[roots[i]];
			i = roots[i];
		}
		return i;
	}

	// put all the elements in add's set to the set of root.
	public void union (int[] roots, int root, int add) {
		int oldRoot = find (roots, add);
		roots[oldRoot] = root;
	}
}
