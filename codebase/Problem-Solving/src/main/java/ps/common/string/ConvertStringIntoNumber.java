package ps.common.string;

public class ConvertStringIntoNumber {
	public static void main(String[] args) {
		String input="123";
		int res=evaluate(input);
		System.out.println(res);
	}

	private static int evaluate(String input) {
		int sum=0;
		for(int i=0;i<input.length();i++) {
			System.out.println(input.charAt(i));
			sum=sum*10+(input.charAt(i)-48);
			System.out.println(sum);
		}
		return sum;
	}

}
