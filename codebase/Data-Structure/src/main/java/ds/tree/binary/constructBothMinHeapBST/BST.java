package ds.tree.binary.constructBothMinHeapBST;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Node{
	int key;
	int priority;
	@Override
	public String toString() {
		return "Node [key=" + key + ", priority=" + priority + "]";
	}
	public Node(int key, int priority) {
		this.key = key;
		this.priority = priority;
		this.left=null;
		this.right=null;
	}
	Node left,right;
}

public class BST {
	Node root;
	public static void main(String[] args) {
		
		List<Node> list=new LinkedList<>();
		list.add(new Node(1, 4));
		list.add(new Node(2, 1));
		list.add(new Node(3, 3));
		list.add(new Node(4, 2));
		list.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.priority-o2.priority;
				
			}
		});
		
		System.out.println(list);
		
		
		BST tree=new BST();
		
		for(int i=0;i<list.size();i++) {
			tree.insert(list.get(i));
		}
		
		System.out.println(tree);
		System.out.println("complete");
		
		
	}

	private void insert(Node node) {
		 root = insertRec(root, node);
	}

	private Node insertRec(Node root, Node key) {
		 /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key.key,key.priority);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key.key < root.key)
            root.left = insertRec(root.left, key);
        else if (key.key > root.key)
            root.right = insertRec(root.right, key);
 
        
        return root;
	
	}

	

}
