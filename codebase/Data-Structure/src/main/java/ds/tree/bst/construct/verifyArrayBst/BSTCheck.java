package ds.tree.bst.construct.verifyArrayBst;

import java.util.LinkedList;
import java.util.Queue;

class NodeDetails {
	public NodeDetails(int data, int min, int max) {
		this.data = data;
		this.min = min;
		this.max = max;
	}

	int data;
	int min, max;
};

public class BSTCheck {
	
	public static void main(String[] args) {
		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		int n = arr.length;
		if (levelOrderIsOfBST(arr, n))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	static boolean levelOrderIsOfBST(int arr[], int n) {
		if (n == 0)
			return true;
		Queue<NodeDetails> q = new LinkedList<>();
		int i = 0;
		NodeDetails newNode = new NodeDetails(arr[i++], Integer.MIN_VALUE, Integer.MAX_VALUE);
		q.add(newNode);
		while (i != n && !q.isEmpty()) {
			NodeDetails temp = q.peek();
			q.remove();
			if (i < n && (arr[i] < temp.data && arr[i] > temp.min)) {
				newNode = new NodeDetails(arr[i++], temp.min, temp.data);
				q.add(newNode);
			}
			if (i < n && (arr[i] > temp.data && arr[i] < temp.max)) {
				newNode = new NodeDetails(arr[i++], temp.data, temp.max);
				q.add(newNode);
			}
		}
		if (i == n)
			return true;
		return false;
	}

}
