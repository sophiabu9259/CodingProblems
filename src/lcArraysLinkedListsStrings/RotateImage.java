package lcArraysLinkedListsStrings;

public class RotateImage {
	public void rotate(int[][] matrix) {
		//Validate Input
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        
        //upside down
        for(int i = 0; i < n; i ++){
        	for(int j = 0; j < m/2; j++){
        		int temp = matrix[j][i];
        		matrix[j][i] = matrix[m-j-1][i];
        		matrix[m-j-1][i] = temp;
        	}
        }
        
        //main diagonal line symmetry
        for(int i = 0; i < m; i++){
        	for(int j = i; j < n; j ++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
    }
}
