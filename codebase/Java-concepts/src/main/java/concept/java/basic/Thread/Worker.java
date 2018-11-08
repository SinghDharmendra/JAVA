package concept.java.basic.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	Random random = new Random();

	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Adding into list1");
		list1.add(random.nextInt(100));

	}

	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Adding into list2");
		list2.add(random.nextInt(100));

	}

	public void process() {
		for (int i = 0; 1 < 10; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Worker main");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

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
		System.out.println("list1 :"+list1.size());
		System.out.println("list2 :"+list2.size());
		System.out.println("time elapsed :"+(System.currentTimeMillis()-start));
	}

}
