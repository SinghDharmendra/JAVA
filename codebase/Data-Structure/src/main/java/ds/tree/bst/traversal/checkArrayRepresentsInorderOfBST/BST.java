package ds.tree.bst.traversal.checkArrayRepresentsInorderOfBST;

public class BST {
	public static void main(String[] args) {
		int arr[] = { 19, 23, 25, 30, 45 };

		if (isInorder(arr, arr.length))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean isInorder(int[] arr, int length) {
		if (length == 0 || length == 1) {
			return true;
		}
		for (int i = 1; i < length; i++) {
			if (arr[i] < arr[i - 1])
				return false;

		}

		return true;
	}

}
