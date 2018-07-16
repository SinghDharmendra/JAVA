package concept.java.basic.overriding;

public class A {
	public void m1() {
		System.out.println("A.m1");
	}

	void m2() {
		System.out.println("A.m2");
	}

	public void m3() {
		System.out.println("A.m3");
	}

	public A m4() {
		return new A();
	}

	public A m5() {
		return new A();
	}

	public B m6() {
		return new B();
	}

}
