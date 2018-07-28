package ps.common.problem;

public class ExcelIndexToNumber {

public static void main(String[] args) {
	String in="CDA";
	int idx=covert(in);
	System.out.println("index:"+idx);
}

private static int covert(String in) {
	char[] charArray = in.toCharArray();
	int result=0;
	for(Character c:charArray) {
		result*=26;
		result=result+c-'A'+1;
	}
	return result;
}
}
