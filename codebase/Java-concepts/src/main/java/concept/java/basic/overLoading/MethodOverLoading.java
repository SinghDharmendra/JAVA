package concept.java.basic.overLoading;

public class MethodOverLoading {
	public static void main(String[] args) {
		// if we just pass (5,6) it will through compilation error
		System.out.println(method(5, 6f));
		
	}
	
	public static int method(int a,float f) {
		return a;
		
	}
	public static int method(float f,int a) {
		return a;
		
	}

}
