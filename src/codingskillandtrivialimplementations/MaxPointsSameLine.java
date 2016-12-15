package codingskillandtrivialimplementations;

import java.util.HashMap;
import java.util.Map;
/**
 * build a hashmap on every points.
 * @author Xuechao
 *
 */
public class MaxPointsSameLine {

	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	public static int maxPoints(Point[] points) {
		if (points.length == 0) {
			return 0;
		}
		int max = 0;
		for (int j = 0; j < points.length; ++j){
			int ret = 1;
			int self = 0;
	        Map<Double, Integer> slopeMap = new HashMap<>();
			for (int i = 0; i < points.length; ++i) {
				if ( i == j) continue;
				Double slope = 0.0;
				if (points[i].x == points[j].x && points[i].y == points[j].y){
					self++;
					continue;
				} else if (points[i].x == points[j].x) {
					slope = Double.MAX_VALUE;
				} else if (points[i].y == points[j].y){
					slope = 0.0;
				} else {
					slope = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
				}
				slopeMap.put(slope, slopeMap.containsKey(slope)? slopeMap.get(slope) + 1 : 2);
				ret = Math.max(ret, slopeMap.get(slope));
			}
			max = Math.max(max, ret + self);
		}
		return max;
	}
	
	public static void main (String[] args) {
		Point[] points = {
				
				new Point(-4,-4),
				new Point(-8,-582),
				new Point(-3,3),
				new Point(-9,651),
				new Point(9,591)
		};
		
		System.out.println(maxPoints(points));
	}
}
