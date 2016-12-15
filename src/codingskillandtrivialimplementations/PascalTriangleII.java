package codingskillandtrivialimplementations;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; ++i) {
			List<Integer> temp = new ArrayList<>(ret);
			for (int j = 1; j < i; ++j) {
				ret.set(j, ret.get(j) + temp.get(j-1));
			}
			ret.add(1);
		}
		return ret;
	}
}
