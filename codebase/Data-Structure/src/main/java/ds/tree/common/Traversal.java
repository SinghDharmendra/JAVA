package ds.tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
	public static void inorder(Node node) {
		inorder(node.left);
		System.out.println(node.data + " ");
		inorder(node.right);
	}

	public static void preOder(Node node) {
		System.out.println(node.data + " ");
		preOder(node.left);
		inorder(node.right);
	}

	public static void postOrder(Node node) {
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data + " ");
	}

	public static void levelOrder(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.data);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

}
