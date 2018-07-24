package concept.java.basic.overriding;

public class B extends A {
	public void m1() {
		System.out.println("B.m2");
	}

	public void m2() {
		System.out.println("A.m2");
	}

	/**
	 * compiler error
	 * Cannot reduce the visibility of the inherited method from A
	 * 
	 */

	/*void m3() {
		System.out.println("A.m3");
	}
*/
	public A m4() {
		return new A();
	}

	public B m5() {
		return new B();
	}

	/**
	 * compiler error
	 * The return type is incompatible with A.m6() Return type of overridden method
	 * can be A higher level Class's object in hierarchy
	 */
	/*public A m6() {
		return new A();
	}*/

}
