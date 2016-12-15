package codingskillandtrivialimplementations;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;

import basicstructures.Interval;
/**
 * sort first. 
 * @author Xuechao
 *
 */
public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare (Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		Set<Interval> toBeRemoved = new HashSet<>();
		Interval first = null;
		for (Interval intvl : intervals) {
			if (first == null) {
				first = intvl;
			} else {
				if (intvl.start > first.end) {
					first = intvl;
				} else {
					first.start = Math.min (first.start, intvl.start);
					first.end = Math.max(first.end, intvl.end);
					toBeRemoved.add(intvl);
				}
			}
		}
		intervals.removeAll(toBeRemoved);
		return intervals;

	}


}
