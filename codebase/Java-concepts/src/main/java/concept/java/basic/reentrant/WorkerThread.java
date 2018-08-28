package concept.java.basic.reentrant;

public class WorkerThread implements Runnable{
	Account from;
	Account to;
	float amt;
	String name;

	@Override
	public void run() {
		try {
			transferMoneyWithTryLock(from, to, amt);
		} catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public WorkerThread(Account from, Account to, float amt, String name) {
		
		this.from = from;
		this.to = to;
		this.amt = amt;
		this.name = name;
	}

	public boolean transferMoneyWithTryLock(Account fromAccount, Account toAccount, float amount)
			throws InsufficientAmountException, InterruptedException {

		// we are defining a stopTime
		long stopTime = System.nanoTime() + 5000;
		while (true) {
			if (fromAccount.lock.tryLock()) {
				try {
					if (toAccount.lock.tryLock()) {
						try {
							if (amount > fromAccount.getCurrentAmount()) {
								throw new InsufficientAmountException("Insufficient Balance");
							} else {
								fromAccount.debit(amount);
								toAccount.credit(amount);
							}

						} finally {
							toAccount.lock.unlock();
						}
					}

				} finally {
					fromAccount.lock.unlock();
				}
			}
			if (System.nanoTime() < stopTime) {
				System.out.println("Returning timeout:"+name);
				return false;
			}
			Thread.sleep(100);
		} // while
	}
	

}
