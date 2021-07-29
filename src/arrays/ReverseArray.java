package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);

		List<Integer> res = ReverseArray.reverseArray(arr);
		System.out.println(res);
	}

	public static List<Integer> reverseArray(List<Integer> a) {
		Collections.reverse(a);
		return a;
	}

}
