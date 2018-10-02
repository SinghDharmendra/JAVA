package ps.common.string;

import java.io.IOException;
import java.util.HashMap;

public class Solution {

	// Complete the isValid function below.
	static String isValid(String s) {

		HashMap<Character, Integer> map = new HashMap();
		HashMap<Integer, Integer> vMap = new HashMap();
		for (int i = 0; i < s.length(); i++) {

			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println(map);
		for (int v : map.values()) {
			if (vMap.containsKey(v)) {
				vMap.put(v, vMap.get(v) + 1);
			} else {
				vMap.put(v, 1);
			}

		}
		System.out.println(vMap);

		if (vMap.size() == 1) {
			return "YES";
		} else if (vMap.size() == 2) {
			int ar[] = new int[2];
			int ark[] = new int[2];
			int j = 0;
			for (int a : vMap.keySet()) {
				ar[j] = vMap.get(a);
				ark[j] = a;
				j++;
			}

			if ((ar[1] == 1 || ar[0] == 1) && (Math.abs(ark[1] - ark[0]) == 1))
				return "YES";
			else if ((!(Math.abs(ark[1] - ark[0]) == 1))
					&& ((ark[0] == 1 && ar[0] == 1) || (ark[1] == 1 && ar[1] == 1)))
				return "YES";
			else
				return "NO";

		} else {
			return "NO";
		}

	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = "aaaaabc";

		String result = isValid(s);

		System.out.println(result);
	}
}
