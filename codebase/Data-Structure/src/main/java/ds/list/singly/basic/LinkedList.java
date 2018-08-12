package ds.list.singly.basic;

/**
 * Basic Functionality of LinkedList <br>
 * addAtBegin <br>
 * addAtEnd <br>
 * printAll <br>
 * removeAtBegin <br>
 * removeAtEnd
 * 
 * @author Dharmendra Singh
 *
 */

public class LinkedList {
	Node root;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addAtEnd(1);
		list.addAtEnd(2);
		list.addAtEnd(3);
		list.addAtEnd(4);
		System.out.println("After addAtEnd");
		list.printAll();
		list.addAtBegin(-5);
		list.addAtBegin(-4);
		list.addAtBegin(-3);
		list.addAtBegin(-2);
		list.addAtBegin(-1);
		System.out.println("\nAfter addAtBegin");
		list.printAll();
		list.removeAtBegin();
		System.out.println("\nAfter removeAtBegin");
		list.printAll();
		list.removeAtEnd();
		System.out.println("\nAfter removeAtEnd");
		list.printAll();
		int count = list.getCount();
		System.out.println("\ncount:" + count);
		count = getCountRecursively(list.root);
		System.out.println("\ncount:" + count);
		list.printAll();
		boolean result = list.search(1);
		System.out.println("\nSearch Result:" + (result == true ? "Found" : "Not Found"));
		result = list.searchRecursively(list.root, 7);
		System.out.println("\nRecursive Search Result:" + (result == true ? "Found" : "Not Found"));
	}

	private boolean searchRecursively(Node root2, int i) {
		if (root2 == null) {			
			return false;
		}
		if (root2.data == i)
			return true;
		return searchRecursively(root2.next, i);
	}

	private boolean search(int i) {
		if (root == null) {
			System.out.println("LinkedList is empty:underflow");
			return false;
		} else {

			Node temp = root;
			while (temp != null) {
				if (temp.data == i) {
					return true;
				}
				temp = temp.next;

			}
		}
		return false;
	}

	private static int getCountRecursively(Node root2) {

		if (root2 == null)
			return 0;
		else {
			return 1 + getCountRecursively(root2.next);

		}

	}

	private int getCount() {
		int count = 0;
		if (root == null)
			return count = 0;
		Node temp = root;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;

	}

	private void removeAtEnd() {
		if (root == null) {
			System.out.println("\nList is empty,Underflow");
			return;
		}
		if (root.next == null) {
			root = null;
		} else {
			Node temp = root;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}

	}

	private void removeAtBegin() {
		if (root == null) {
			System.out.println("\nList is empty,Underflow");
			return;
		}
		if (root.next == null) {
			root = null;
		} else {
			Node temp = root;
			root = root.next;
			temp.next = null;
		}

	}

	private void addAtBegin(int i) {

		Node temp;
		if (root == null) {
			root = new Node(i);
		} else {
			temp = new Node(i);
			temp.next = root;
			root = temp;
		}

	}

	private void printAll() {
		Node temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	private void addAtEnd(int i) {
		Node temp;
		if (root == null) {
			root = new Node(i);
		} else {
			temp = root;
			while (temp.next != null)
				temp = temp.next;
			temp.next = new Node(i);

		}

	}

}

/**
 * 
 * Node for LinkedList
 *
 */

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
