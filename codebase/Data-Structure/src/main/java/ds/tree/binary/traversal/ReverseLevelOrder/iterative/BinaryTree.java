package ds.tree.binary.traversal.ReverseLevelOrder.iterative;

//A recursive java program to print reverse level order traversal
//using stack and queue

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ds.tree.common.Node;

/**
 * A recursive java program to print <br>
 * reverse levelorder traversal <br>
 * using queue and stack <br>
 * 
 * @author Dharmendra Singh
 *
 */

class BinaryTree {
	Node root;

	void reverseLevelOrder(Node node) {
		Stack<Node> S = new Stack<>();
		Queue<Node> Q = new LinkedList<>();
		Q.add(node);

		while (!Q.isEmpty()) {
			node = Q.peek();
			Q.remove();
			S.push(node);
			if (node.right != null)
				Q.add(node.right);
			if (node.left != null)
				Q.add(node.left);
		}

		while (!S.empty()) {
			node = S.peek();
			System.out.print(node.data + " ");
			S.pop();
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("Level Order traversal of binary tree is :");
		tree.reverseLevelOrder(tree.root);

	}
}
