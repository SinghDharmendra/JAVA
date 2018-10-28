package ds.stack.application;

import java.util.Stack;

public class InfixToPrefixConversion {
	public static void main(String[] args) {
		String s = ("(a-b/c)*(a/k-l)");
		System.out.println(infixToPrefix(s));

	}

	private static String infixToPrefix(String s) {
		char[] charArray = s.toCharArray();
		String result = "";
		reverse(charArray, 0, charArray.length - 1);
		String io = new StringBuilder(s).reverse().toString();
		for (int i = 0; i < io.length(); i++) {

			if (charArray[i] == '(') {
				charArray[i] = ')';
				i++;
			} else if (charArray[i] == ')') {
				charArray[i] = '(';
				i++;
			}
		}
		String post = convertToPost(String.valueOf(charArray));
		char[] postFix = post.toCharArray();
		reverse(postFix, 0, postFix.length - 1);
		return String.valueOf(postFix);

	}

	static int getPriority(char C) {
		if (C == '-' || C == '+')
			return 1;
		else if (C == '*' || C == '/')
			return 2;
		else if (C == '^')
			return 3;
		return 0;
	}

	private static String convertToPost(String infix) {
		Stack<Character> charStack = new Stack<>();

		infix = '(' + infix + ')';
		int l = infix.length();

		String output = "";

		for (int i = 0; i < l; i++) {

			// If the scanned character is an
			// operand, add it to output.
			if (Character.isLetterOrDigit(infix.charAt(i)))
				output += infix.charAt(i);

			// If the scanned character is an
			// ‘(‘, push it to the stack.
			else if (infix.charAt(i) == '(')
				charStack.push('(');

			// If the scanned character is an
			// ‘)’, pop and output from the stack
			// until an ‘(‘ is encountered.
			else if (infix.charAt(i) == ')') {

				while (charStack.peek() != '(') {
					output += charStack.peek();
					charStack.pop();
				}

				// Remove '(' from the stack
				charStack.pop();
			}

			// Operator found
			else {

				if (!Character.isLetterOrDigit(charStack.peek())) {
					while (getPriority(infix.charAt(i)) <= getPriority(charStack.peek())) {
						output += charStack.peek();
						charStack.pop();
					}

					// Push current Operator on stack
					charStack.push(infix.charAt(i));
				}
			}
		}
		return output;

	}

	private static void reverse(char[] charArray, int start, int end) {
		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;

		}

	}

}
