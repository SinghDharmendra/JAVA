package ds.list.singly.basic;

import java.util.HashSet;

public class RemoveDuplicates
{
    static class Node
    {
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
        }
    }

    /* Function to remove duplicates from a
       unsorted linked list */
    static void removeDuplicate(Node head){
        Node current=head;
        Node prev=null;
        HashSet<Integer> set=new HashSet<>();
        while(current!=null){
            int curVal=current.val;
            if(set.contains(curVal)){
                prev.next=current.next;
            }else{
                set.add(curVal);
                prev=current;
            }
            current=current.next;

        }

    }


    /* Function to print nodes in a given linked list */
    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removeDuplicate(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }
}
