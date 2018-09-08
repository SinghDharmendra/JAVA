package ps.common.problem;

public class SegregateEvenOddInArray {
	public static void main(String[] args) {
		int arr[] = { 12, 34, 45, 9, 8, 90, 3 };

		segregateEvenOdd(arr);
	}

	private static void segregateEvenOdd(int[] arr) {
		int l = 0, h = arr.length - 1;
		while (l < h) {
			while (arr[l] % 2 == 0 && l < h)
				l++;
			while (arr[h] % 2 == 1 && l < h)
				h--;

			if (l < h) {
				int temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
				l++;
				h--;
			}

		}

		for (int a : arr)
			System.out.print(a + " ");

	}

}
