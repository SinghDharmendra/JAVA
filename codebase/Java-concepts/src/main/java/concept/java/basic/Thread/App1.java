package concept.java.basic.Thread;

public class App1 {
	private int count=0;

	public synchronized void increment() {
		count++;
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("count:" + count);
	}

	public static void main(String[] args) {
		App1 app = new App1();
		app.doWork();
		System.out.println("count:" + app.count);
	}

}
