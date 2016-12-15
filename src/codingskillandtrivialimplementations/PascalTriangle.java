package codingskillandtrivialimplementations;
import java.util.List;
import java.util.ArrayList;
/**
 * shift last line 1 unit to the right and add to it self to get next line.
 * @author Xuechao
 *
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<>();
		if (numRows == 0) return ret;
		List<Integer> first = new ArrayList<>();
		first.add(1);
		ret.add(first);
		for (int i = 1; i < numRows; ++i) {
			List<Integer> temp = new ArrayList<>(ret.get(i-1));
			for (int j = 1; j < i ; ++j) {
				temp.set(j, temp.get(j) + ret.get(i-1).get(j-1));
			}
			temp.add(ret.get(i-1).get(i-1));
			ret.add(temp);
		}
		return ret;
	}
}
