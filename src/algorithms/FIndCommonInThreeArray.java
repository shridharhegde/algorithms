package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FIndCommonInThreeArray {

	public static void main(String[] args) {
		Integer ar1[] = { 1, 5, 10, 20, 40, 80 };
		Integer ar2[] = { 6, 7, 20, 80, 100 };
		Integer ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
		System.out.println(findCommon(Arrays.asList(ar1), Arrays.asList(ar2), Arrays.asList(ar3)));

	}

	public static List<Integer> findCommon(List<Integer> A, List<Integer> B, List<Integer> C) {
		HashSet<Integer> res = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// int num;
		for (int i = 0; i < A.size(); i++) {
			if (!map.containsKey(A.get(i))) {
				map.put(A.get(i), 1);
			}
		}
		for (int i = 0; i < B.size(); i++) {
			if (!map.containsKey(B.get(i))) {
				map.put(B.get(i), 2);
			} else {
				if (map.get(B.get(i)) != 2) {
					res.add(B.get(i));
				}
			}
		}

		for (int i = 0; i < C.size(); i++) {
			if (!map.containsKey(C.get(i))) {
				map.put(C.get(i), 3);
			} else {
				if (map.get(C.get(i)) != 3) {
					res.add(C.get(i));
				}
			}
		}
		ArrayList<Integer> r = new ArrayList<Integer>(res);
		Collections.sort(r);
		return r;
	}

}
