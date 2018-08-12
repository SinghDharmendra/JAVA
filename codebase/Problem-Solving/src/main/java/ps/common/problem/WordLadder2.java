package ps.common.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordLadder2 {
	public static void main(String[] args) {
		List<String> lst = new LinkedList<>();
		lst.add("<!Entity a1 100;600;500>");

		lst.add("<!Entity a2 a1;a3>");
		lst.add("<!Entity a3 200>");
		entityExpansion(10, lst);

	}

	// Complete the entityExpansion function below.
	static void entityExpansion(long l, List<String> entities) {
		int count = 0;

		Map<String, List<String>> map = new HashMap();
		for (String s : entities) {
			// System.out.println(s);
			String h[] = s.split(" ");
			String key = h[1];
			int j = 2;
			String val = h[j];

			while (val.length() == 0) {
				val = h[++j];
			}

			val = val.replaceAll(">", "");
			String[] values = val.split(";");

			if (!map.containsKey(key)) {
				List<String> ob = new ArrayList();
				for (String v : values) {
					ob.add(v);
				}
				map.put(key, ob);

			}

		 }

		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		Set<String> keySet = map.keySet();

		for (String x:keySet) {
			int c = 0;
			String k =x;
			List<String> list = map.get(k);
			for (String b : list) {
				if (map.containsKey(b))
					c += map.get(b).size();
				else
					c++;
			}

			count += c;
		}

		System.out.println((count < l ? 1 : 0) + " " + count);
	}

}
