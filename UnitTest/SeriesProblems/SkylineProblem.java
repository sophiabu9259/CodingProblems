package SeriesProblems;

import java.util.LinkedList;
import java.util.List;

public class SkylineProblem {
	public List<int[]> outline (int[][] input) {

		return divide (input, 0, input.length);

	}


	public LinkedList<int[]> divide (int[][] input, int start, int end) {

		LinkedList<int[]> ret;

		if (start < end) {

			int mid = (start + end) / 2;

			LinkedList<int[]> left = divide (input, start, mid);

			LinkedList<int[]> right = divide (input, mid + 1, end);

			ret =  conquer (left, right);

		} else {

			ret = new LinkedList<>();

			ret.add( new int[] { input[start][0], input[start][2]});

			ret.add( new int[] { input[start][1], 0});

		}


		return ret;

	}


	public LinkedList<int[]> conquer (LinkedList<int[]> l1, LinkedList<int[]> l2) {

		int h = 0;

		int lastH = 0;

		int x = -1;

		LinkedList<int[]> ret = new LinkedList<>();


		while (l1.size() > 0 && l2.size() > 0) {

			int[] e1 = l1.get(0);

			int[] e2 = l2.get(0);

			if (e1[0] < e2[0]) {

				h = Math.max(h, e1[1]);

				x = e1[0];

				l1.removeFirst();

			} else if (e1[0] > e2[0]) {

				h = Math.max(h, e2[1]);

				x = e2[0];

				l2.removeFirst();

			} else {

				x = e1[0];

				h = Math.max(h, Math.max(e1[1], e2[1]));

				l1.removeFirst();

				l2.removeFirst();

			}


			if (h != lastH) {

				ret.add (new int[] { x, h}) ;

				lastH = h;

			}

		}


		ret.addAll(l2);

		return ret;
	}
}
