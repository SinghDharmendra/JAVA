package ps.common.problem;

import java.util.HashMap;
import java.util.Map;

public class ExcelIndexToNumber {

	public static void main(String[] args) {
		String in = "CDA";
		int idx = covert(in);
		printString(idx);
		System.out.println("index:" + idx);
	}

	private static void printString(int columnNumber) {
		StringBuilder columnName = new StringBuilder();
		while (columnNumber > 0) {
			int rem = columnNumber % 26;
			// If remainder is 0, then a
			// 'Z' must be there in output
			if (rem == 0) {
				columnName.append("Z");
				columnNumber = (columnNumber / 26) - 1;
			} else // If remainder is non-zero
			{
				columnName.append((char) ((rem - 1) + 'A'));
				columnNumber = columnNumber / 26;
			}
		}
		// Reverse the string and print result
		System.out.println(columnName.reverse());
	}

	private static int covert(String in) {
		char[] charArray = in.toCharArray();
		int result = 0;
		for (Character c : charArray) {
			result *= 26;
			result = result + c - 'A' + 1;
		}
		return result;
	}
}
