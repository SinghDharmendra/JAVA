package ps.common.problem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicate {
	public static void main(String[] args) {
		String in="geeks for geeks";
		String result=removeDuplicates(in);
		System.out.println("result:"+result);
	}

	private static String removeDuplicates(String in) {
		String res="";
		Map<Character, Integer> map=new LinkedHashMap<>();
		char[] charArray = in.toCharArray();
		for(Character ch:charArray) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		Set<Character> keySet = map.keySet();
		StringBuilder sb=new StringBuilder("");
		for(Character c:keySet)
			sb.append(c);
		res=sb.toString();
		return res;
	}
	

}
