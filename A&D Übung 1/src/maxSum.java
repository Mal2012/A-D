public final class maxSum {
	static public int seqStart = 0;
	static public int seqEnd = -1;

	/**
	 * Cubic maximum contiguous subsequence sum algorithm. seqStart and seqEnd
	 * represent the actual best sequence.
	 */
	public static int maxSubSum1(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
			for (int j = i; j < a.length; j++) {
				int thisSum = 0;

				for (int k = i; k <= j; k++)
					thisSum += a[k];

				if (thisSum > maxSum) {
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}

		return maxSum;
	}

	/**
	 * Quadratic maximum contiguous subsequence sum algorithm. seqStart and
	 * seqEnd represent the actual best sequence.
	 */
	public static int maxSubSum2(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];

				if (thisSum > maxSum) {
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}
		}

		return maxSum;
	}

	/**
	 * Linear-time maximum contiguous subsequence sum algorithm. seqStart and
	 * seqEnd represent the actual best sequence.
	 */
	public static int maxSubSum3(int[] a) {
		int maxSum = 0;
		int thisSum = 0;

		for (int i = 0, j = 0; j < a.length; j++) {
			thisSum += a[j];

			if (thisSum > maxSum) {
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			} else if (thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}

		return maxSum;
	}

	static int maxSumRec(int[] a) {
		if (a.length == 1) {
			if (a[0] <= 0) {
				return 0;
			} else {
				return a[0];
			}
		} else {
			int[] linkesarray, rechtesarray; // Devide -Start
			linkesarray = new int[a.length / 2];
			System.arraycopy(a, 0, linkesarray, 0, (a.length / 2));

			rechtesarray = new int[a.length / 2];
			System.arraycopy(a, (a.length) / 2 + 1, rechtesarray, 0,
					a.length / 2 - 1);
			// Devide -End
			// Conquer - Start
			int maxLeftSum = maxSumRec(linkesarray);
			int maxRightSum = maxSumRec(rechtesarray);

			int subLeftArray = 0, subRightArray = 0;
			int maxLeftArray = 0, maxRightArray = 0;

			for (int i = (a.length) / 2; i >= 0; i--) {
				subLeftArray += a[i];
				if (subLeftArray > maxLeftArray) {
					maxLeftArray = subLeftArray;
				}
			}
			for (int i = (a.length) / 2 + 1; i < a.length; i++) {
				subRightArray += a[i];

				if (subRightArray > maxRightArray) {
					maxRightArray = subRightArray;
				}
			}
			// Conquer - End

			return Math.max(maxLeftSum,
					Math.max(maxRightSum, maxLeftArray + maxRightArray)); // Merge
		}
	}

	static int maxSubSumRec(int[] a, int left, int right) {
		if (left == right) {
			if (a[left] <= 0) {
				return 0;
			} else {
				return a[left];
			}
		} else {

			int maxLeftSum = maxSubSumRec(a, left, ((right + left) / 2));
			int maxRightSum = maxSubSumRec(a, (left + right) / 2 + 1, right);
			int subLeftArray = 0, subRightArray = 0;
			int maxLeftArray = 0, maxRightArray = 0;

			for (int i = (right + left) / 2; i >= 0; i--) {
				subLeftArray += a[i];
				if (subLeftArray > maxLeftArray) {
					maxLeftArray = subLeftArray;
				}
			}
			for (int i = (right + left) / 2 + 1; i < a.length; i++) {
				subRightArray += a[i];

				if (subRightArray > maxRightArray) {
					maxRightArray = subRightArray;
				}
			}

			return Math.max(maxLeftSum,
					Math.max(maxRightSum, maxLeftArray + maxRightArray));
		}
	}

	/**
	 * Return maximum of three integers.
	 */
	private static int max3(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}

	/**
	 * Simple test program.
	 */
	public static void main(String[] args) {
		// int a[] = { 3, -3, 2, 0, 3, 1, 3, -2 };
		int a[] = { 4, -3, 5, -2, -1, 2, 6, -2 };
		// int a[] = { 1, 2, -2, 1 };
		int maxSum;

		maxSum = maxSubSum1(a);
		System.out.println("Max sum is " + maxSum + "; it goes" + " from "
				+ seqStart + " to " + seqEnd);
		maxSum = maxSubSum2(a);
		System.out.println("Max sum is " + maxSum + "; it goes" + " from "
				+ seqStart + " to " + seqEnd);
		maxSum = maxSubSum3(a);
		System.out.println("Max sum is " + maxSum + "; it goes" + " from "
				+ seqStart + " to " + seqEnd);

		maxSum = maxSumRec(a);
		System.out.println("\nMax sum is " + maxSum + ";");
		maxSum = maxSubSumRec(a, 0, a.length - 1);
		System.out.println("\nMax sum is " + maxSum + ";");
	}
}
