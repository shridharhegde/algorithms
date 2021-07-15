package algorithms;

public class PatternMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));

	}

	public static boolean isMatch(String s, String p) {

		boolean firstMatch = false;
		if (p.isEmpty())
			return s.isEmpty();
		if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
			firstMatch = true;
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}

}
