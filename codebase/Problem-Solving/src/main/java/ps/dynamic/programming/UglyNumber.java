package ps.dynamic.programming;

public class UglyNumber {
	public static void main(String[] args) {
		System.out.println(getUgly(150));
	}

	private static int getUgly(int n) {
		int ugly[] = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		int nextMultipleOfTwo = 2;
		int nextMultipleOfThree = 3;
		int nextMultipleOfFive = 5;
		int nextUglyNumber = 1;
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			nextUglyNumber = Math.min(nextMultipleOfTwo, Math.min(nextMultipleOfThree, nextMultipleOfFive));
			ugly[i] = nextUglyNumber;
			if (nextUglyNumber == nextMultipleOfTwo) {
				i2 = i2 + 1;
				nextMultipleOfTwo = ugly[i2] * 2;

			}

			if (nextUglyNumber == nextMultipleOfThree) {
				i3 = i3 + 1;
				nextMultipleOfThree = ugly[i3] * 3;

			}

			if (nextUglyNumber == nextMultipleOfFive) {
				i5 = i5 + 1;
				nextMultipleOfFive = ugly[i5] * 5;

			}

		}

		return nextUglyNumber;
	}
	
	static int getNthUglyNo(int n) 
    { 
        int ugly[] = new int[n];  // To store ugly numbers 
        int i2 = 0, i3 = 0, i5 = 0; 
        int next_multiple_of_2 = 2; 
        int next_multiple_of_3 = 3; 
        int next_multiple_of_5 = 5; 
        int next_ugly_no = 1; 
          
        ugly[0] = 1; 
          
        for(int i = 1; i < n; i++) 
        { 
            next_ugly_no = Math.min(next_multiple_of_2, 
                                  Math.min(next_multiple_of_3, 
                                        next_multiple_of_5)); 
              
            ugly[i] = next_ugly_no; 
            if (next_ugly_no == next_multiple_of_2) 
            { 
               i2 = i2+1; 
               next_multiple_of_2 = ugly[i2]*2; 
            } 
            if (next_ugly_no == next_multiple_of_3) 
            { 
               i3 = i3+1; 
               next_multiple_of_3 = ugly[i3]*3; 
            } 
            if (next_ugly_no == next_multiple_of_5) 
            { 
               i5 = i5+1; 
               next_multiple_of_5 = ugly[i5]*5; 
            } 
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no; 
    } 

}
