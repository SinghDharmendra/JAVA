package ps.common.problem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static void main(String[] args) {
		String in1 = "abcdef";
		String in2 = "defabc";
		boolean result = isAnagram(in1, in2);
		System.out.println("result:" + result);
	}

	private static boolean isAnagram(String in1, String in2) {
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray1 = in1.toCharArray();
		char[] charArray2 = in2.toCharArray();
		for (Character ch : charArray1) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		for (Character ch : charArray2) {

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
			} else {
				map.put(ch, -1);
			}
		}
		return map.values().stream().mapToInt(Math::abs).sum() == 0 ? true : false;

	}

}
