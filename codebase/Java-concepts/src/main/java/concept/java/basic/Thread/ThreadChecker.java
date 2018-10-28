package concept.java.basic.Thread;

public class ThreadChecker {
	public static synchronized void m1() {
		System.out.println("syn m1");
	}

	public synchronized void m2() {
		System.out.println("syn m2");
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadChecker a = new ThreadChecker();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				a.m1();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				a.m2();

			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				a.m1();

			}
		});
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	
		
		t3.join();
	}

}
