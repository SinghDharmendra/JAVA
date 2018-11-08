package concept.java.basic.array;

public class LocalMinima {
	public static void main(String[] args) {
		int arr[] = { 8, 5, 2 };
		int n = arr.length;
		System.out.println("Index of a local minima is " + localMin(arr, n));
	}

	private static int localMin(int[] arr, int n) {
		return localMinimaUtil(arr, 0, n - 1, n);
	}

	private static int localMinimaUtil(int[] arr, int l, int h, int n) {
		int mid = l + (h - l) / 2;
		if ((mid == 0 || arr[mid] < arr[mid - 1]) && (mid == n - 1 || arr[mid] < arr[mid + 1]))
			return mid;
		else if (mid > 0 && arr[mid] > arr[mid - 1])
			return localMinimaUtil(arr, l, mid - 1, n);
		else
			return localMinimaUtil(arr, mid + 1, h, n);
	}

}
