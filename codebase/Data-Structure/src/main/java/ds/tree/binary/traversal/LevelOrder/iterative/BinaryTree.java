package ds.tree.binary.traversal.LevelOrder.iterative;

import java.util.Queue;
import ds.tree.common.Node;
import java.util.LinkedList;

/**
 * Class to print Level Order Traversal iterative
 * 
 * @author Dharmendra Singh
 *
 */
class BinaryTree {

	Node root;

	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		Node dummy=new Node(Integer.MIN_VALUE);
		queue.add(root);
		queue.add(dummy);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if(tempNode==dummy){

				System.out.println();
				if(queue.size()>1)
				queue.add(dummy);
				continue;
			}
			System.out.print(tempNode.data + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String args[]) {

		BinaryTree tree_level = new BinaryTree();
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}
}