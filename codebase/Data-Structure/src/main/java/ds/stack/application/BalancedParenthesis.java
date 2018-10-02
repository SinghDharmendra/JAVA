package ds.stack.application;

import java.util.Scanner;
import java.util.Stack;

/**
 * Java program for checking balanced Parenthesis of expression
 * 
 * @author Dharmendra Singh
 *
 */
public class BalancedParenthesis {

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	static boolean areParenthesisBalanced(String in) {
		char exp[] = in.toCharArray();
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				if (st.isEmpty()) {
					return false;
				} else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}
		}
		if (st.isEmpty())
			return true;
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		if (areParenthesisBalanced(input))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

}