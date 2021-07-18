package algorithms;

public class MinimumCostToDivideChain {

	public static void main(String[] args) {
	System.out.println(minCost(new int[] {5,2,4,6,3,7}));

	}

	public static int minCost(int[] A) {
		if (A.length < 5)
			return -1;

		int minSum = Integer.MAX_VALUE;

		for (int i = 1; i < A.length - 3; i++)
			for (int j = i + 2; j < A.length - 1; j++) {
				if (minSum > (A[i] + A[j])) {
					minSum = A[i] + A[j];
				}
			}
		return minSum;
	}

}
