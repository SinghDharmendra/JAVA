package ds.tree.binary.traversal.sortArrayOfBStRepresentation;

public class SortArray {
	public static void main(String[] args) {
		int arr[] = { 4, 2, 5, 1, 3 };
		printSorted(arr, 0, arr.length - 1);
	}

	private static void printSorted(int[] arr, int start, int end) {
		if (start > end)
			return;
		printSorted(arr, start * 2 + 1, end);
		System.out.print(arr[start] + " ");
		printSorted(arr, start * 2 + 2, end);

	}

}
