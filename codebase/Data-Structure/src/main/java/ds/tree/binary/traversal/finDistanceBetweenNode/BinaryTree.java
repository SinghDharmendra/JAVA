package ds.tree.binary.traversal.finDistanceBetweenNode;

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
		root.right.left.right = new Node(8);
		System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));

		System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));

		System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));

		System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));

		System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
	}

	private static int findDistance(Node root, int n1, int n2) {
		Node lca = findLCA(root, n1, n2);
		return distance(lca, n1, 0) + distance(lca, n2, 0);

	}

	private static int distance(Node node, int n, int level) {
		if (node == null)
			return -1;
		if (node.data == n)
			return level;
		int left = distance(node.left, n, level + 1);
		if (left == -1)
			return distance(node.right, n, level + 1);
		else
			return left;

	}

	private static Node findLCA(Node root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.data == n1 || root.data == n2)
			return root;
		Node leftLCA = findLCA(root.left, n1, n2);
		Node rightLCA = findLCA(root.right, n1, n2);

		if (leftLCA != null && rightLCA != null)
			return root;
		return (leftLCA != null) ? leftLCA : rightLCA;

	}

}
