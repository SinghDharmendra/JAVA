package concept.java.basic;

/**
 * 
 * @author Dharmendra Singh 
 * In Java for all premitive data types values is
 * copied while passing in method i.e. the ref in passing method will
 * hold the value,it will not hold object's ref in Case of Passing
 * object ref is actually passed not the values are just copied
 * 
 *
 */

public class ObjectPassingInJava {
	public static void main(String[] args) {
		int a = 10;
		int ar[] = { 1, 2, 3, 4, 5 };
		Employee e = new Employee("1", "Dharmendra", "208015");
		String s = "someValue";
		Integer in = Integer.valueOf(5);
		pass(a, ar, e, s, in);
		System.out.println("in main method");
		System.out.println("a:" + a + "\nar:");

		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + ", ");
		System.out.println();
		System.out.println("e:" + e);
		System.out.println("s:" + s);
		System.out.println("Integer:" + in);

	}

	private static void pass(int a, int[] ar, Employee e, String s, Integer in) {
		System.out.println("entry of mathod");
		System.out.println("a:" + a + "\nar:");
		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + ", ");
		System.out.println();
		System.out.println("e:" + e);
		System.out.println("s:" + s);
		System.out.println("Integer:" + in);
		a = 20;
		ar[2] = 11;
		e.setPin("560068");
		s = "otherValue";
		in = Integer.valueOf(8);
		System.out.println("exit of mathod");
		System.out.println("a:" + a + "\nar:");
		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + ", ");
		System.out.println();
		System.out.println("e:" + e);
		System.out.println("s:" + s);
		System.out.println("Integer:" + in);

	}

}
