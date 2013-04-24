package karman.concurrent;

public class SleeperThread extends Thread {

	int seconds;

	public SleeperThread(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public void run() {
		try {
			System.out.println("going to sleep for " + seconds + " seconds");
			Thread.sleep(seconds * 1000);
			System.out.println("awake after sleeping for " + seconds
					+ " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
