package ds.tree.binary.traversal.roottospecificnode;

import java.util.Vector;

import ds.tree.common.Node;

public class BinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int x = 5;
		printPath(root, x);

	}

	private static void printPath(Node root, int x) {
		Vector<Integer> arr = new Vector<Integer>();
		if (hasPath(root, x, arr)) {
			for (Integer i : arr)
				System.out.println(i + ", ");
		} else {
			System.out.println("No path");
		}

	}

	private static boolean hasPath(Node root, int x, Vector<Integer> arr) {
		if (root == null)
			return false;
		arr.addElement(root.data);

		if (root.data == x)
			return true;
		if (hasPath(root.left, x, arr) || hasPath(root.right, x, arr))
			return true;
		arr.removeElement(root.data);

		return false;
	}

}
