package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTriplests {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3)
			return Collections.emptyList();

		Map<String, List<Integer>> tripletMap = new HashMap<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum == 0) {
					tripletMap.put(nums[i] + "-" + nums[j] + "-" + nums[k], Arrays.asList(nums[i], nums[j], nums[k]));

					j++;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return new ArrayList<>(tripletMap.values());
	}

}
