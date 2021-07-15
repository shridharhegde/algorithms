package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombincationOfPhoneNumber {

	public static void main(String[] args) {
		 System.out.println(letterCombinations("01"));
	}

	// Function that creates the mapping and
	// calls letterCombinationsUtil
	static List<String> letterCombinations(String digits) {
		 String[] table = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	        int[] number = new int[digits.length()];
	        for (int j =0; j< digits.length(); j++) {
	            number[j] = Integer.valueOf(Character.toString(digits.charAt(j)));
	        }
	        // To store the generated letter combinations
			List<String> list = new ArrayList<>();

			Queue<String> q = new LinkedList<>();
			q.add("");

			while (!q.isEmpty()) {
				String s = q.remove();

				// If complete word is generated
				// push it in the list
				if (s.length() == digits.length())
					list.add(s);
				else {
					String val = table[number[s.length()]];
					for (int i = 0; i < val.length(); i++) {
						q.add(s + val.charAt(i));
					}
				}
			}
			for (int i = 0; i< list.size(); i++) {
				if (list.get(i).isEmpty()) list.remove(list.get(i));
			}
			return list;
	}

}
