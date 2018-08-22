package ds.tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
	public static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.printf(node.data + " ");
		inorder(node.right);
	}

	public static void preOder(Node node) {
		if (node == null)
			return;
		System.out.printf(node.data + " ");
		preOder(node.left);
		inorder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.printf(node.data + " ");
	}

	public static void levelOrder(Node node) {
		if (node == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

}
