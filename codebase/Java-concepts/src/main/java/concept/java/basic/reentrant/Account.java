package concept.java.basic.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
	float amount;
	ReentrantLock lock;
	public float getCurrentAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	public void debit(float amount2) {
		this.amount-=amount2;
		
	}
	public void credit(float amount2) {
		this.amount+=amount2;
		
	}
	public Account(float amount, ReentrantLock lock) {	
		this.amount = amount;
		this.lock = lock;
	}
	

}
