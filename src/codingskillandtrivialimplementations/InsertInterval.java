package codingskillandtrivialimplementations;

import java.util.ArrayList;
import java.util.List;
/**
 * create a new list. compare new interval with original lists. insert smaller one. merge overlapped ones.
 * add new interval at last. (original n intervals, after loop, result only have n elements)
 * @author Xuechao
 *
 */
public class InsertInterval {

	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();

		for (Interval intvl : intervals) {
			if (newInterval.end < intvl.start) {
				result.add(newInterval);
				newInterval = intvl;
			} else if (intvl.end < newInterval.start) {
				result.add(intvl);
			} else {
				newInterval = new Interval(Math.min(intvl.start, newInterval.start), Math.max(intvl.end, newInterval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
}
