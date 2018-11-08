package ds.tree.binary.traversal.postOrder.iterative;


import java.util.Stack;

import ds.tree.common.Node;
import ds.tree.common.TreeTraversal;

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
		bt.postOrderIterative(bt.root);

	}

	private void postOrderIterative(Node root) {
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node temp=s1.pop();
			s2.push(temp);
			if(temp.left!=null)
				s1.push(temp.left);
			if(temp.right!=null)
				s1.push(temp.right);
			
			
		}
		while(!s2.isEmpty())
			System.out.println(s2.pop().data);
		System.out.println("Post order traversal");
		TreeTraversal.postOrder(root);
		
		
	}

}
