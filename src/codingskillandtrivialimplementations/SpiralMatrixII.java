package codingskillandtrivialimplementations;
/**
 * Use i == n - 1 - i to find when there is only one spot left, because general four direction
 * generation cannot be used on this only-1 senario.
 * @author Xuechao
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int filler = 1;
		for (int i = 0; i <= (n-1)/2; ++i) {
			if ( i == n - 1 - i) {
				ret[i][i] = filler;
				break;
			}
			for (int j = i; j < n - 1 - i; ++j) {
				ret[i][j] = filler++;
			}
			for (int j = i; j < n - 1 - i; ++j) {
				ret[j][n-1-i] = filler++;
			}
			for (int j = n - 1 - i; j > i; --j) {
				ret[n-1-i][j] = filler++;
			}
			for (int j = n - 1 - i; j > i; --j) {
				ret[j][i] = filler++;
			}
		}
		return ret;
	}
}
