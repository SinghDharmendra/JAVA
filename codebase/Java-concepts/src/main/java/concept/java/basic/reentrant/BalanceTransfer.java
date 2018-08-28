package concept.java.basic.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class BalanceTransfer {
	public static void main(String[] args) {
		System.out.println("Inside main");
		ReentrantLock rel=new ReentrantLock();
		Account A=new Account(200, new ReentrantLock());
		Account B=new Account(200, new ReentrantLock());
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		WorkerThread T1=new WorkerThread(A, B, 40, "T1");
		WorkerThread T2=new WorkerThread(B, A, 40, "T2");
		pool.execute(T1);
		pool.execute(T2);
		
		
		
	}

}
