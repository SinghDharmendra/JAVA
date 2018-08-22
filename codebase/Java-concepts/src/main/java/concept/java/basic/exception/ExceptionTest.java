package concept.java.basic.exception;

public class ExceptionTest {
	public static void main(String[] args) throws InputException {
		int a=4,b=-5;
		System.out.println(sum(a,b));
	}

	private static int sum(int a, int b) throws InputException {
		int sum=0;
		if(a>0&&b>0) {
			sum=a+b;
		}else {
			throw new InputException("invalid input");
		}
		return sum;
	}

}
