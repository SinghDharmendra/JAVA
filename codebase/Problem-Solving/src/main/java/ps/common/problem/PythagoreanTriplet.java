package ps.common.problem;

import java.util.Arrays;

public class PythagoreanTriplet {
	public static void main(String[] args) {
		 // int arr[] = {3, 1, 4, 6, 5};
		int arr[]={10, 4, 6, 12, 5};
		  
	        int arr_size = arr.length;
	        if (isTriplet(arr,arr_size)==true)
	           System.out.println("Yes");
	        else
	           System.out.println("No");  
	}

	private static boolean isTriplet(int[] arr, int arr_size) {
		for(int i=0;i<arr_size;i++)
			arr[i]=arr[i]*arr[i];
		Arrays.sort(arr);
		for(int i=arr_size-1;i>1;i--) {
			int l=0,h=i-1;
			while(l<h) {
				if(arr[i]==arr[l]+arr[h]) {
					System.out.println("Found");
					return true;
				}else if(arr[i]>arr[l]+arr[h]) {
					l++;
				}else {
					h--;
				}
			}
			
		}
		
		
		return false;
	}

}
