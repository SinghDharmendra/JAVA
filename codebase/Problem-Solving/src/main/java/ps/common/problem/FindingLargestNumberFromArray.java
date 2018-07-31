package ps.common.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This problem is about forming largest number from the values i.e. passed as
 * List of String
 * 
 * @author Dharmendra Singh
 *
 */

public class FindingLargestNumberFromArray {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		Collections.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String x = o1 + o2;
				String y = o2 + o1;
				return y.compareTo(x);
			}
		});
		System.out.println("out");

		arr.stream().forEach(System.out::print);
	}

}
