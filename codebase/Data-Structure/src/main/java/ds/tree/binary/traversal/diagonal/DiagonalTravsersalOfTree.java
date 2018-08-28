package ds.tree.binary.traversal.diagonal;

import java.util.LinkedList;
import java.util.Queue;

import ds.tree.common.Node;

public class DiagonalTravsersalOfTree {
	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		diagonalPrint(root);
	}

	private static void diagonalPrint(Node root) {
		System.out.println("Inside method");
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node dummy = null;

		q.add(dummy);
		while (!q.isEmpty()) {

			Node temp = q.peek();
			q.remove(temp);

			if (temp == dummy) {
				if (q.isEmpty())
					return;
				System.out.println();
				q.add(dummy);

			} else {

				while (temp != null) {
					System.out.print(temp.data + " ");
					if (temp.left != null)
						q.add(temp.left);
					temp = temp.right;
				}
			}

		}

	}

}
