package ds.tree.binary.traversal.roottoleaf.allpath.iteration;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Node{
	public Node(int data) {
		
		this.data = data;
	}
	int data;
	Node left,right;
}

public class BinaryTree {
	Node root;
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);		
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right=new Node(2);
		

		tree.printPaths(tree.root);
	}
	private void printPaths(Node root2) {
		Map<Node, Node> parentMap=new HashMap<Node, Node>();
		if(root2==null)
			return;
		Stack<Node> st=new Stack<Node>();
		parentMap.put(root2, null);
		st.push(root2);
		
		while(!st.isEmpty()) {
			Node current = st.pop();
			if(current.left==null&&current.right==null) {
				printTopToBottom(current,parentMap);
			}
			
			if(current.left!=null)
			{
				st.push(current.left);
				parentMap.put(current.left, current);
			}
			if(current.right!=null)
			{
				st.push(current.right);
				parentMap.put(current.right, current);
			}
			
		}
		
	}
	private void printTopToBottom(Node current, Map<Node, Node> parentMap) {
		Stack<Node> print=new Stack<Node>();
		while(current!=null) {
			print.push(current);
			current=parentMap.get(current);
		}
		for(;!print.isEmpty();) {
			System.out.print(print.pop().data+" ");
		}
		System.out.println();
	}
	

}
