package ds.tree.binary.traversal.LevelOrder.recursive;

import ds.tree.common.Node;
import ds.tree.common.TreeUtil;

/**
 * Recursive Java program for level order traversal of Binary Tree
 * @author Dharmendra Singh
 *
 */


class BinaryTree {
	// Root of the Binary Tree
	Node root;

	public BinaryTree() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = TreeUtil.height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}