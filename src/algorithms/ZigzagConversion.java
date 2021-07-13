package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));

	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		List<StringBuilder> zigzag = new ArrayList<>();
		boolean down = true;
		int rows = 0;
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			zigzag.add(new StringBuilder());
		}
		for (char a : s.toCharArray()) {
			zigzag.get(rows).append(a);
			if(rows == numRows || rows ==  (numRows - 1)) {
				down = false;
			}
			if (rows <= 0) {
				down = true;
			}
			rows += (down) ? 1 : -1;
		}
		StringBuilder ans = new StringBuilder();
		for (int i =0; i< zigzag.size(); i++) {
			ans.append(zigzag.get(i));
		}
		return ans.toString();
	}

}
