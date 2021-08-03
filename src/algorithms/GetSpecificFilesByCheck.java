package algorithms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSpecificFilesByCheck {

	public static void main(String[] args) {
		String test = " 715K 2009-09-23 system.zip~\n 179K 2013-08-14 to-do-list.xml~\n 645K 2013-06-19 blockbuster.mpeg~\n  536 2010-12-12 notes.html\n 688M 1990-02-11 delete-this.zip~\n  23K 1987-05-24 setup.png~\n 616M 1965-06-06 important.html\n  14M 1992-05-31 crucial-module.java~\n 192K 1990-01-31 very-long-filename.dll~";
		System.out.println(getFileMatched(test));
	}

	private static String getFileMatched(String S) {
		String[] lines = S.split("[\\r\\n]+");
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < lines.length; i++) {
			String eachLine = lines[i].trim();
			System.out.println(eachLine);
			String[] words = eachLine.split(" ");
			if (isBackUpFile(words[2]) && isSizeMatched(words[0]) && isDateMatched(words[1])) {
				int length = words[2].split("\\.")[0].length();
				System.out.println(length);
				if (length < minLength)
					minLength = length;
			}
		}
		if (minLength < Integer.MAX_VALUE)
			return String.valueOf(minLength);
		return "NO FILES";
	}

	public static boolean isBackUpFile(String fileName) {
		if (fileName != null && !fileName.isEmpty() && fileName.endsWith("~")) {
			return true;
		}
		return false;
	}

	public static boolean isSizeMatched(String size) {
		int matchingSize = 14680064;
		int actualSize = 0;
		if (size.endsWith("K")) {
			actualSize = Integer.valueOf(size.substring(0, size.length() - 1)) * 1024;
		} else if (size.endsWith("M")) {
			actualSize = Integer.valueOf(size.substring(0, size.length() - 1)) * 1024 * 1024;
		} else if (size.endsWith("G")) {
			actualSize = Integer.valueOf(size.substring(0, size.length() - 1)) * 1024 * 1024 * 1024;
		} else {
			actualSize = Integer.valueOf(size);
		}
		if (actualSize < matchingSize)
			return true;
		return false;
	}

	public static boolean isDateMatched(String date) {
		String matchingLastModifiedDateStr = "1990-01-31";
		try {
			Date matchingLastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").parse(matchingLastModifiedDateStr);
			Date lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			if (lastModifiedDate.after(matchingLastModifiedDate))
				return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
