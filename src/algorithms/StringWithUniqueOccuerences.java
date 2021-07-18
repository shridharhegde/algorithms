package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringWithUniqueOccuerences {

	public static void main(String[] args) {
		System.out.println(minCntCharDeletionsfrequency("example"));

	}

	public static int minCntCharDeletionsfrequency(String S) {
		char[] str = S.toCharArray();
		int size = S.length();
		HashMap<Character, Integer> countMap = new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (countMap.containsKey(str[i])) {
				countMap.put(str[i], countMap.get(str[i]) + 1);
			} else {
				countMap.put(str[i], 1);
			}
		}
		for (Map.Entry<Character, Integer> it : countMap.entrySet()) {
			queue.add(it.getValue());
		}
		while (!queue.isEmpty()) {
			int frequency = queue.peek();
			queue.remove();
			if (queue.isEmpty()) {
				return count;
			}
			if (frequency == queue.peek()) {
				if (frequency > 1) {
					queue.add(frequency - 1);
				}
				count++;
			}
		}

		return count;
	}

}
