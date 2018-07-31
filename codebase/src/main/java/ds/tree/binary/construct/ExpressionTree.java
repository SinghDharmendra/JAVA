package ds.tree.binary.construct;

import ds.tree.common.Node;

public class ExpressionTree {
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	    ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
		
	}

	private Node constructTree(char[] charArray) {
		
		return null;
	}
	 void inorder(Node t) {
	        if (t != null) {
	            inorder(t.left);
	            System.out.print(t.value + " ");
	            inorder(t.right);
	        }
	    }

}
