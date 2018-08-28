package ps.common.string;

/**
 * Given an input string, reverse the string word by word.<br>
 * A word is defined as a sequence of non-space characters.
 * 
 * @author Dharmendra Singh
 *
 */

public class ReverseWordsInString {

	public static void main(String[] args) {
		String in = "Red hot blue";
		char[] charArray = in.toCharArray();
		ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
		reverseWordsInString.reverseWords(charArray);
		System.out.println(String.valueOf(charArray));

	}

	public void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}

		reverse(s, i, s.length - 1);

		reverse(s, 0, s.length - 1);
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

}
