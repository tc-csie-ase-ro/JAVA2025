package eu.ase.threads;

public class Main {

	
	
	public static void main(String[] args) {

		ThreadNonSync thread1 = new ThreadNonSync("thread1");
		ThreadNonSync thread2 = new ThreadNonSync("thread2");
		
		System.out.println("Non Synchronized: ");

		try {
			thread1.start();
			thread2.start();
			
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ThreadSync thread1s = new ThreadSync("thread1");
		ThreadSync thread2s = new ThreadSync("thread2");
		
		System.out.println("Synchronized: ");
		
		thread1s.start();
		thread2s.start();
		
		try {
			thread1s.join();
			thread2s.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main program finished");

	}

}
