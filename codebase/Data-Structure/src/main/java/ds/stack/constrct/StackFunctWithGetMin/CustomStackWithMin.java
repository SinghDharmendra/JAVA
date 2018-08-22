package ds.stack.constrct.StackFunctWithGetMin;

import java.util.*;

class MyStack {
	Stack<Integer> s;
	Integer minEle;

	// Constructor
	MyStack() {
		s = new Stack<Integer>();
	}

	// Prints minimum element of MyStack
	void getMin() {
		// Get the minimum number in the entire stack
		if (s.isEmpty())
			System.out.println("Stack is empty");

		// variable minEle stores the minimum element
		// in the stack.
		else
			System.out.println("Minimum Element in the " + " stack is: " + minEle);
	}

	// prints top element of MyStack
	void peek() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		Integer t = s.peek(); // Top element.

		System.out.print("Top Most Element is: ");

		// If t < minEle means minEle stores
		// value of t.
		if (t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}

	/**
	 * Pop() : Removes an element from top of stack.<br>
	 * Remove element from top. Let the removed element be y. Two cases arise:<br>
	 * If y is greater than or equal to minEle, the minimum element in the stack is
	 * still minEle.<br>
	 * If y is less than minEle, the minimum element now becomes (2*minEle – y),
	 * <br>
	 * so update (minEle = 2*minEle – y). This is where we retrieve previous minimum
	 * from current minimum and its value in stack.
	 */
	void pop() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		Integer t = s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - t;
		}

		else
			System.out.println(t);
	}

	/**
	 * 
	 * Push(x) : Inserts x at the top of stack.<br>
	 * 
	 * If stack is empty, insert x into the stack and make minEle equal to x.<br>
	 * If stack is not empty, compare x with minEle. Two cases arise:<br>
	 * If x is greater than or equal to minEle, simply insert x.<br>
	 * If x is less than minEle, insert (2*x – minEle) into the stack and make
	 * minEle equal to x.<br>
	 */
	void push(Integer x) {
		if (s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}

		else
			s.push(x);

		System.out.println("Number Inserted: " + x);
	}
};

// Driver Code
public class CustomStackWithMin {
	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.push(1);
		s.getMin();
		s.pop();
		s.getMin();
		s.pop();
		s.peek();
	}
}