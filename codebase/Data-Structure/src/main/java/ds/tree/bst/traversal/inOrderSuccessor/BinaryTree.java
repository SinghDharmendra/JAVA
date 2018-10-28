package ds.tree.bst.traversal.inOrderSuccessor;

//Java program to find minimum value node in Binary Search Tree

//A binary tree node
class Node {

	int data;
	Node left, right, parent;

	Node(int d) {
		data = d;
		left = right = parent = null;
	}
}

class Counter {
	int c;

	public Counter() {
	}

}

class BinaryTree {

	static Node head;

	/*
	 * Given a binary search tree and a number, inserts a new node with the given
	 * number in the correct place in the tree. Returns the new root pointer which
	 * the caller should then use (the standard trick to avoid using reference
	 * parameters).
	 */
	Node insert(Node node, int data) {

		/*
		 * 1. If the tree is empty, return a new, single node
		 */
		if (node == null) {
			return (new Node(data));
		} else {

			Node temp = null;

			/* 2. Otherwise, recur down the tree */
			if (data <= node.data) {
				temp = insert(node.left, data);
				node.left = temp;
				temp.parent = node;

			} else {
				temp = insert(node.right, data);
				node.right = temp;
				temp.parent = node;
			}

			/* return the (unchanged) node pointer */
			return node;
		}
	}

	Node inOrderSuccessor(Node root, Node n) {

		// step 1 of the above algorithm
		if (n.right != null) {
			return minValue(n.right);
		}

		// step 2 of the above algorithm
		Node p = n.parent;
		while (p != null && n == p.right) {
			n = p;
			p = p.parent;
		}
		return p;
	}

	/*
	 * Given a non-empty binary search tree, return the minimum data value found in
	 * that tree. Note that the entire tree does not need to be searched.
	 */
	Node minValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node root = null, temp = null, suc = null, min = null;
		root = tree.insert(root, 20);
		root = tree.insert(root, 8);
		root = tree.insert(root, 22);
		root = tree.insert(root, 4);
		root = tree.insert(root, 12);
		root = tree.insert(root, 10);
		root = tree.insert(root, 14);
		temp = root.left.right;
		// suc = tree.inOrderSuccessor(root, temp);
		suc = tree.inOrderSuccessorWithoutParent(root, temp);

		if (suc != null) {
			System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
		} else {
			System.out.println("Inorder successor does not exist");
		}

		tree.findSecondLargestElement(root);

		tree.findLArgestNumber(root, 6);
		tree.findSmallestNumber(root, 1);
	}

	private void findSmallestNumber(Node root, int n) {
		Counter c = new Counter();
		findSmallestRec(root, c, n);

	}

	private void findSmallestRec(Node root, Counter c, int n) {

		if (root == null || c.c >= n) {
			return;
		}
		findSmallestRec(root.left, c, n);
		c.c++;
		if (c.c == n) {
			System.out.println(n + "th smallest ele :" + root.data);
			return;
		}
		findSmallestRec(root.right, c, n);
	}

	private void findLArgestNumber(Node root, int nl) {

		Counter c = new Counter();
		findSecLargestRec(root, c, nl);

	}

	private void findSecLargestRec(Node root, Counter c, int nl) {

		if (root == null || c.c >= nl) {
			return;
		}

		this.findSecLargestRec(root.right, c, nl);
		c.c++;
		if (c.c == nl) {
			System.out.println(nl + "th largest ele :" + root.data);
			return;
		}
		this.findSecLargestRec(root.left, c, nl);

	}

	private void findSecondLargestElement(Node root) {
		Counter c = new Counter();
		findSecLargestRec(root, c);

	}

	private void findSecLargestRec(Node root, Counter c) {
		if (root == null || c.c >= 2) {
			return;
		}

		this.findSecLargestRec(root.right, c);
		c.c++;
		if (c.c == 2) {
			System.out.println("second largest ele :" + root.data);
			return;
		}
		this.findSecLargestRec(root.left, c);

	}

	private Node inOrderSuccessorWithoutParent(Node root, Node temp) {
		if (temp.right != null) {
			return minValue(temp.right);
		}

		Node suc = null;

		while (root != null) {
			if (temp.data > root.data) {
				root = root.right;
			} else if (temp.data < root.data) {
				suc = root;
				root = root.left;
			} else
				break;
		}
		return suc;
	}
}

