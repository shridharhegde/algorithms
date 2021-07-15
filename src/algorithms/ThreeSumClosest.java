package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));

	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target)
					return sum;
				if (sum < target) {
					j++;
					if (target - sum < closest) {
						closest = target - sum;
						map.put(closest, sum);
					}
				} else {
					k--;
					if (sum - target < closest) {
						closest = sum - target;
						map.put(closest, sum);
					}
				}
			}
		}
		return map.get(closest);
	}
}
