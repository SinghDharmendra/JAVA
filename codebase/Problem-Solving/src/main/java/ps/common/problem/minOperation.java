package ps.common.problem;
//print minimum operation required to make all elements of an array

class minOperation {
	/*
	 * Function to print minimum operation required to make all elements of an array
	 * equal
	 */
	static void printMinOp(int arr[]) {
		int arraySum, smallest, arr_size = arr.length;
		arraySum = 0;
		smallest = arr[0];
		for (int i = 0; i < arr_size; i++) {
			/*
			 * If current element is smaller than update smallest
			 */
			if (arr[i] < smallest)
				smallest = arr[i];

			/* find array sum */
			arraySum += arr[i];
		}

		int minOperation = arraySum - arr_size * smallest;

		System.out.println(String.format("%s,%s,%s",arraySum,arr_size,smallest));
		/* Print min operation required */
		System.out.println("Minimum Operation = " + minOperation);

	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 4, 3, 4 };
		printMinOp(arr);
	}
}