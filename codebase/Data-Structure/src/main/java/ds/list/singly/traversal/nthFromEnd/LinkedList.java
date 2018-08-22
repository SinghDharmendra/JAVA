package ds.list.singly.traversal.nthFromEnd;

import ds.common.list.Node;

/**
 * Java program to find n'th node from end<br>
 * using slow and fast pointers
 * 
 * @author Dharmendra Singh
 *
 */

class LinkedList {
	Node head;

	void printNthFromLast(int n) {
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {
					System.out.println(n + " is greater than the no " + " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}
			while (ref_ptr != null) {
				main_ptr = main_ptr.next;
				ref_ptr = ref_ptr.next;
			}
			System.out.println("Node no. " + n + " from last is " + main_ptr.data);
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		llist.printNthFromLast(4);
	}
}