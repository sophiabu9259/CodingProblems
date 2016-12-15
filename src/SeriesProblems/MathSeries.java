package SeriesProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MathSeries {
	static class PerfectSqueare {
		public int numSquaresDP(int n) {
			int max = (int) Math.sqrt(n);
			int[] dp = new int[n+1];
			Arrays.fill(dp, Integer.MAX_VALUE);

			for (int i = 1; i <= n; ++i) {
				for  (int j = 1; j <= max; j++) {
					if ( i == j * j) {
						dp[i] = 1;
					} else if (i > j*j) {
						dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
					}
				}
			}

			return dp[n];

		}

		class Node {
			int level;
			int val;
			Node (int i, int j) {
				this.level = i;
				this.val = j;
			}
		}

		public int numSquares(int n) {
			Queue<Node> q = new LinkedList<>();
			int max = (int) Math.sqrt(n);
			int[] squares = new int[max + 1];
			for (int i = 1;  i <= max; ++i) {
				squares[i] = i*i;
			}
			for (int i = max; i >=1; i--) {
				if (squares[max] < n) {
					q.offer(new Node(1, n - squares[max]));
				}
			}

			while (!q.isEmpty()) {
				Node top = q.poll();
				if (top.val == 0) {
					return top.level;
				}
				for (int i = max; i >=1; i--) {
					if (squares[max] <= top.val) {
						q.offer(new Node(top.level + 1, top.val - squares[max]));
					}
				}
			}
			return -1;
		}
	}
}
