package ps.common.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInString {
	public static void main(String[] args) {
		String input = "GeeksforGeeks";
		char c = findFirstNonRepeatedChar(input);
		System.out.println(c);
	}

	private static char findFirstNonRepeatedChar(String input) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (char c : map.keySet()) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return '0';
	}

}
