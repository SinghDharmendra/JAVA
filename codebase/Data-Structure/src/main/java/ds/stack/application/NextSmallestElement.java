package ds.stack.application;

import java.util.HashMap;
import java.util.Map;
/*public class NextSmallestElement {

}*/
import java.util.Stack;

class NextSmallestElement {
	/*
	 * prints element and NSE pair for all elements of arr[] of size n
	 */
	public static void printNSE(int arr[], int n) {
		Stack<Integer> s = new Stack<Integer>();

		s.push(arr[0]);

		for (int i = 1; i < n; i++) {

			if (!s.isEmpty()) {
				while (s.empty() == false && s.peek() > arr[i]) {
					System.out.println(s.peek() + " --> " + arr[i]);
					s.pop();
				}
			}

			s.push(arr[i]);
		}

		while (s.empty() == false) {
			System.out.println(s.peek() + " --> " + "-1");
			s.pop();
		}
	}

	static void printNSEImp(int arr[], int n) {
		Stack<Integer> s = new Stack<>();
		Map<Integer, Integer> mp = new HashMap<>();

		s.push(arr[0]);

		for (int i = 1; i < n; i++) {

			if (s.empty()) {
				s.push(arr[i]);
				continue;
			}

			while (s.empty() == false && s.peek() > arr[i]) {
				mp.put(s.pop(), arr[i]);

			}

			s.push(arr[i]);
		}

		while (s.empty() == false) {
			mp.put(s.peek(), -1);
			s.pop();
		}

		for (int i = 0; i < n; i++)
			System.out.println(arr[i] + "=====>" + mp.get(arr[i]));

	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 ,1};
		int n = arr.length;
		printNSEImp(arr, n);
		// printNSE(arr, n);
	}
}
