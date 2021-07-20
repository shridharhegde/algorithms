package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ArrayRotation {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>(); 
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		List<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(3);
		System.out.println(solve(A, B));

	}

	public static int GCD(int m, int n) {

		while (n != 0) {
			int temp = n;
			n = m % n;
			m = temp;
		}

		return m;
	}

	public static List<List<Integer>> solve(List<Integer> A, List<Integer> B) {

		List<List<Integer>> all_rotated_lists = new ArrayList<>();

		for (Integer d : B) {
			d = d % A.size();
			int n = A.size();
			// Identify number of `sets` as per Juggling Approach
			int sets = GCD(n, d);

			ArrayList<Integer> temp_list = new ArrayList<Integer>(A);

			// System.out.println("Sets = "+sets);
			for (int j = 0; j < sets; j++) {

				int temp = temp_list.get(j);
				int curr = j;
				int next = j;
				do {

					next = next + d;
					if (next >= n) {
						next = next - n;
					}

					// System.out.println(temp_list.toString()+"=="+curr+"--"+next);
					temp_list.set(curr, temp_list.get(next));

					curr = next;

				} while (next != j);

				if (j - d < 0) {
					temp_list.set(n + j - d, temp);
				} else {
					temp_list.set(j - d, temp);
				}
			}
			// System.out.println();
			all_rotated_lists.add(temp_list);
		}

		return all_rotated_lists;
	}

}
