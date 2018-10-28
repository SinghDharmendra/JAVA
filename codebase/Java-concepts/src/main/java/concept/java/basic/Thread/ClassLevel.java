package concept.java.basic.Thread;

public class ClassLevel {
	public static void main(String[] args) {
		Thread t1=new A("t1");
		Thread t2=new A("t2");
		t1.start();
		t2.start();
	}
}

class A extends Thread {
	public A(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		

	}
	public static synchronized void m1() throws InterruptedException {
		System.out.println("m1");
		Thread.sleep(2000);
		System.out.println("m1 end");
	}
	public static  void m2() throws InterruptedException {
		System.out.println("m2");
		Thread.sleep(2000);
		System.out.println("m2 end");
	}

}

class B extends Thread {
	public B(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());

	}
	public static synchronized void m1() throws InterruptedException {
		System.out.println("m1");
		Thread.sleep(2000);
		System.out.println("m1 end");
	}
	public static  void m2() throws InterruptedException {
		System.out.println("m2");
		Thread.sleep(2000);
		System.out.println("m2 end");
	}

}

	
