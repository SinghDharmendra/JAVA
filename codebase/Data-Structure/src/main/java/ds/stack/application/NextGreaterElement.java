package ds.stack.application;

import java.util.Stack;

//Java program to print next
//greater element using stack

public class NextGreaterElement {

	static void printNGE(int arr[], int n) {
		int i = 0;

		Stack<Integer> s = new Stack<>();
		int element, next;
		s.push(arr[0]);
		for (i = 1; i < n; i++) {
			next = arr[i];

			if (s.isEmpty() == false) {
				while(!s.isEmpty()&& s.peek()<arr[i]) {
					System.out.println(s.pop()+"==>"+arr[i]);					
				}
				
				/*element = s.pop();
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (s.isEmpty() == true)
						break;
					element = s.pop();
				}
				if (element > next)
					s.push(element);*/
			}
			s.push(next);
		}
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + "==>" + next);
		}
	}

	public static void main(String[] args) {
		int arr[] = {20,22,25,4,3,2,1,27};
		int n = arr.length;
		printNGE(arr, n);
	}
}
