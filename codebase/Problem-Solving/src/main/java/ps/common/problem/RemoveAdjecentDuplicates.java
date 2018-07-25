package ps.common.problem;

import java.util.Stack;
/**
 * 
 * Using stack, Keep discarding the same upcoming literal 
 * Then pop out that top from statck
 * At the end you are left with values that are not duplicate
 *
 */

public class RemoveAdjecentDuplicates {
	public static void main(String[] args) {
		String input = "acaaabbbacdddd";
		removeAdjDuplicates(input);
	}

	private static void removeAdjDuplicates(String input) {
		Stack<Character> s = new Stack<>();
		s.push(input.charAt(0));

		for (int i = 1; i < input.length();) {
			if (s.peek() == input.charAt(i)) {
				while (i < input.length() && input.charAt(i) == s.peek()) {
					i++;
				}
				s.pop();
			} else {
				s.push(input.charAt(i));
				i++;
			}

		}

		System.out.println(s);
	}

}
