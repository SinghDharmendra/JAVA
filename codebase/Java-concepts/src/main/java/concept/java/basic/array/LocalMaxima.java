package concept.java.basic.array;

public class LocalMaxima {
	public static void main(String[] args) {
		int arr[] = { 8, 5, 2 };
		int n = arr.length;
		int index = localMax(arr, n);
		System.out.printf("Index of a local minima is{%s} ,value [%s]", index, arr[index]);
	}

	private static int localMax(int[] arr, int n) {
		return localMaximaUtil(arr, 0, n - 1, n);
		
	}

	private static int localMaximaUtil(int[] arr, int l, int h, int n) {
		int mid = l + (h - l) / 2;
		if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1]))
			return mid;
		else if (mid > 0 && arr[mid] < arr[mid - 1])
			return localMaximaUtil(arr, l, mid - 1, n);
		else
			return localMaximaUtil(arr, mid + 1, h, n);
	}

}
