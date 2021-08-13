package algorithms;

import java.util.Set;
import java.util.TreeSet;

public class SmallestIntegerInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[] A) {

        Set<Integer> set = new TreeSet<>();

        for (int a : A) {
            set.add(a);
        }

        int N = set.size();

        int[] C = new int[N];

        int index = 0;

        for (int a : set) {
            C[index++] = a;
        }

        for (int i = 0; i < N; i++) {

            if (C[i] > 0 && C[i] <= N) {
                C[i] = 0;
            }
        }

        for (int i = 0; i < N; i++) {

            if (C[i] != 0) {
                return (i + 1);
            }
        }

        return (N + 1);
    }

}
