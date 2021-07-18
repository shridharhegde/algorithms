package algorithms;

public class BiggestFragment {

	public static void main(String[] args) {
		System.out.println(solution("88"));

	}

	public static int solution(String S) {
		int max = 0;
		for (int i = 0; i < S.length() - 1; i++) {
			int twoDigit = Integer.valueOf(Character.toString(S.charAt(i)) + Character.toString(S.charAt(i + 1)));
			if (twoDigit > max) {
				max = twoDigit;
			}
		}
		return max;

	}

}
