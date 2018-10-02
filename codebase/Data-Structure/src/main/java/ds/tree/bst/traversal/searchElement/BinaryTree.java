package ds.tree.bst.traversal.searchElement;

import ds.tree.common.Node;

public class BinaryTree {
	Node root;

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node root = insert(bt.root, 30);

		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);
		if (search(root, 65))
			System.out.println("Yes");
		else
			System.out.println("No");
		if (searchIterative(root, 80))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean searchIterative(Node root, int data) {
		while (root != null) {
			if (data > root.data)
				root = root.right;
			else if (data < root.data)
				root = root.right;
			else
				return true;
		}
		return false;
	}

	private static boolean search(Node root, int data) {
		if (root != null) {
			if (root.data == data)
				return true;
			if (data > root.data)
				return search(root.right, data);
			else if (data < root.data)
				return search(root.left, data);
		}
		return false;
	}

	private static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (data > root.data)
			root.right = insert(root.right, data);
		else if (data < root.data)
			root.right = insert(root.left, data);
		return root;
	}

}
