package algorithms;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){}}{"));

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty())
					return false;
				char poppedChar = stack.pop();
				if (poppedChar == '(' && c != ')')
					return false;
				else if (poppedChar == '{' && c != '}')
					return false;
				else if (poppedChar == '[' && c != ']')
					return false;
			}

		}
		if (stack.isEmpty())
			return true;
		return false;
	}

}
