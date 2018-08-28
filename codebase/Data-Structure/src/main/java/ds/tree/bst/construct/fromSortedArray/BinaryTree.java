package ds.tree.bst.construct.fromSortedArray;

import ds.tree.common.Node;
import ds.tree.common.TreeTraversal;

/**
 * This class is used to construct a BST from sorted array
 * 
 * @author Dharmendra Singh
 *
 */

public class BinaryTree {
	Node root;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		tree.root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		TreeTraversal.preOrder(tree.root);
	}

	private Node sortedArrayToBST(int[] arr, int low, int high) {
		if (low > high)
			return null;
		int mid = (low + high) / 2;
		Node node = new Node(arr[mid]);
		node.left = sortedArrayToBST(arr, low, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, high);
		return node;
	}

}
