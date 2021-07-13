package algorithms;

public class MyAtoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("+-12"));

	}

	public static int myAtoi(String s) {
		s = s.trim();

		// sanity check
		if (s == null || s.length() == 0) {
			return 0;
		}

		// declare result of type double to handle overflow cases
		double result = 0;

		// check for positive or negative sign
		boolean isNegative = false;
		int startIndex = 0;

		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			++startIndex;
		}

		if (s.charAt(0) == '-') {
			isNegative = true;
		}

		// handle numeric case = "123"
		for (int i = startIndex; i < s.length(); i++) {
			// handle for non numeric characters
			if (s.charAt(i) < '0' || s.charAt(i) > '9') { // checking if ascii value is below or above 0 or 9
				break;
			}
			int digitValue = (int) (s.charAt(i) - '0');
			result = result * 10 + digitValue;
		}

		// toggle result in case of negative is true
		if (isNegative) {
			result = -result;
		}

		// handle underflow
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		// handle overflow
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		// return result
		return (int) result;
	}

}
