package ds.tree.binary.traversal.inorder.iterative;

import java.util.Stack;

import ds.tree.common.Node;

public class BinaryTree {

	Node root;

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.inorderIterative(bt.root);

	}

	private void inorderIterative(Node root2) {
		System.out.println("inorderIterative");
		if (root2 == null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Node current = root2;

		while (current != null || s1.size() > 0) {
			while (current != null) {
				s1.push(current);
				current = current.left;
			}
			current = s1.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}

	}

}
