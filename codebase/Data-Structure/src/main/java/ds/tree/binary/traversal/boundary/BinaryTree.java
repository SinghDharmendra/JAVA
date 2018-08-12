package ds.tree.binary.traversal.boundary;

import ds.tree.common.Node;

public class BinaryTree {
	Node root;

	private void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.data+" ");
			printLeftBoundary(node.left);
			printLeaf(node.left);
			printLeaf(node.right);
			printRightBoundary(node.right);
		}

	}

	private void printRightBoundary(Node node) {	
		if (node != null) {
			if (node.right != null) {
				System.out.print(node.data+" ");
				printLeftBoundary(node.right);
			}else if(node.left != null) {
				System.out.print(node.data+" ");
				printLeftBoundary(node.left);
			}
		}

	
		
	}

	private void printLeaf(Node node) {
	
		if(node!=null) {
			printLeaf(node.left);
			if(node.left==null&&node.right==null)
				System.out.print(node.data+" ");
			printLeaf(node.right);
		}
		
	}

	private void printLeftBoundary(Node node) {		
		if (node != null) {
			if (node.left != null) {
				System.out.print(node.data+" ");
				printLeftBoundary(node.left);
			}else if(node.right != null) {
				System.out.print(node.data+" ");
				printLeftBoundary(node.right);
			}
		}

	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.printBoundary(tree.root);

	}

}
