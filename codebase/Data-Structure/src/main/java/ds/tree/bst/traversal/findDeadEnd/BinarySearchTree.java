package ds.tree.bst.traversal.findDeadEnd;

import ds.tree.common.Node;

/**
 * Program to check if there<br>
 * is a dead end in bst or not.<br>
 * This trick is based on building BST using MIN,MAX values for a node and then
 * finding a proper place to insert the node. In this approach Whenever we end
 * up any node where we are getting MIN=MAX the node is basically a deadend node
 * 
 * @author Dharmendra Singh
 *
 */
class BinarySearchTree {

	Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int data) {
		root = insertrec(root, data);
	}

	Node insertrec(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data)
			root.left = insertrec(root.left, data);
		else if (data > root.data)
			root.right = insertrec(root.right, data);

		return root;
	}

	boolean deadend(Node root, int min, int max) {

		if (root == null)
			return false;

		// if this occurs means dead end is present.
		if (min == max)
			return true;

		// heart of the recursion lies here.
		return deadend(root.left, min, root.data - 1) || deadend(root.right, root.data + 1, max);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(7);
		tree.insert(11);
		tree.insert(4);

		if (tree.deadend(tree.root, 1, Integer.MAX_VALUE) == true)

			System.out.println("yes ");
		else
			System.out.println("no ");
	}
}

// this code is contributed by gitanjali.