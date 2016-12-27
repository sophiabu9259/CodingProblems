package bitree_series;

public class BalanceSum {
	public int findPivot (int[] arr) {
		if (arr == null || arr.length == 0) return -1;
		BIT bit = new BIT (arr);

		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			int left = bit.sumTo (i - 1);
			int right = bit.sumTo (arr.length) - arr[i] - left;
			if (left == right) return i;
		}

		return res;
	}

	class BIT {
		int[] partialSum;
		int[] arr;

		BIT (int[] arri) {
			this.partialSum = new int[arri.length + 1];
			this.arr = new int[arri.length];

			for (int i = 0; i < arri.length; ++i) {
				update (i, arri[i]);
			}

		}

		void update (int index, int value) {
			int diff = value - arr[index];
			arr[index] += diff;
			for (int i = index + 1; i < partialSum.length; i += (i & (-i))) {
				partialSum[i] += diff;
			}
		}

		int sumTo (int index) {
			
			if (index == -1 ) return 0;
			if (index == arr.length) index = arr.length - 1;
			
			int res = 0;
			for (int i = index + 1; i > 0; i -= (i & (-i))) {
				res += partialSum[i];
			}

			return res;
		}

	}
}
