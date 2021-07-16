package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Find4Sum {

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] {2,2,2,2,2}, 8));

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		if (nums.length < 4) {
			return Collections.emptyList();
		}
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1, l = nums.length - 1; k < l;) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> found = new ArrayList<Integer>();
						found.add(nums[i]);
						found.add(nums[j]);
						found.add(nums[k]);
						found.add(nums[l]);
						if (!hSet.contains(found)) {
							hSet.add(found);
							result.add(found);
						}

						k++;
						l--;

					}
				}
			}
		}
		return result;
	}

}
