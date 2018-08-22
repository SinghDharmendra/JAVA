package ps.common.problem;

import java.util.HashSet;
import java.util.Set;

public class AllSubstringOfString {
	public static void main(String[] args) {
		 String str = "abcd";
		/* Set<String> all=getAllSubstring(str);
		 System.out.println(all);
		 */
		 
		 printSubStringOnLength(str);
	}

	private static Set<String> getAllSubstring(String in) {
		HashSet<String> result = new HashSet<>();

		for(int i=0;i<in.length();i++) {
			for(int j=in.length();j>i;j--) {				
				result.add(in.substring(i, j));
				System.out.println(in.substring(i, j));
			}
		}
		return result;
	}

		public static void printSubStringOnLength(String data) {
		      for (int end = data.length(); end >0; end--) {
		         for (int start = 0; start <= data.length()-end; start++) {
		            System.out.println(data.substring(start, start+end));
		         }
		      }
		   } 
		 


}
