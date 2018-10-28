package ds.tree.binary.traversal.preorderusingInPost;

import java.util.Stack;
import java.util.HashMap;

public class PrintPre {

	static int postIndex;

	// Fills preorder traversal of tree with given
	// inorder and postorder traversals in a stack
	void fillPre(int[] in, int[] post, int inStrt, int inEnd, Stack<Integer> s, HashMap<Integer, Integer> hm) {
		System.out.println(inStrt+", "+inEnd+", "+postIndex);
		if (inStrt > inEnd)
			return;

		// Find index of next item in postorder traversal in
		// inorder.
		int val = post[postIndex];
		int inIndex = hm.get(val);
		postIndex--;

		// traverse right tree
		fillPre(in, post, inIndex + 1, inEnd, s, hm);

		// traverse left tree
		fillPre(in, post, inStrt, inIndex - 1, s, hm);

		s.push(val);
	}

	// This function basically initializes postIndex
	// as last element index, then fills stack with
	// reverse preorder traversal using printPre
	void printPreMain(int[] in, int[] post) {
		int len = in.length;
		postIndex = len - 1;
		Stack<Integer> s = new Stack<Integer>();

		// Insert values in a hash map and their indexes.
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++)
			hm.put(in[i], i);

		// Fill preorder traversal in a stack
		fillPre(in, post, 0, len - 1, s, hm);

		// Print contents of stack
		while (s.empty() == false)
			System.out.print(s.pop() + " ");
	}

	// Driver code
	public static void main(String ars[]) {
		int in[] = {4,2,5,1,6,3,7 };
		int post[] = {4,5,2,6,7,3,1};
		PrintPre tree = new PrintPre();
		tree.printPreMain(in, post);
	}
}