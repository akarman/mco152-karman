package karman.concurrent;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread t1 = new SleeperThread(10);
		Thread t2 = new SleeperThread(20);

		t2.start();// DO NOT CALL RUN!!!! THAT JUST RUNS THIS
		t1.start();

	}

}
