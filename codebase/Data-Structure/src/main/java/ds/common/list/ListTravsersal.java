package ds.common.list;

public class ListTravsersal {
	public static void printAll(Node node) {
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
	}

}
