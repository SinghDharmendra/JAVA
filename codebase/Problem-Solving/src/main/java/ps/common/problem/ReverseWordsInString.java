package ps.common.problem;

import java.util.Arrays;

public class ReverseWordsInString {
	public static void main(String[] args) {
		String input="i like this program very much";
		
		String out="much very program this like i"; 
		String ar[]=input.split(" ");
		int i,j;
		
		for(i=0,j=ar.length-1;i<j;i++,j--) {
			String temp=ar[i];
			ar[i]=ar[j];
			ar[j]=temp;
			
			
		}
		
		for(String in:ar)
			System.out.print(in +" ");
		
	}

}
