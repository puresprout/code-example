package concurrency;

public class StopThread {

	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}
			}
		});

		backgroundThread.start();

		Thread.sleep(1000);

		stopRequested = true;
		backgroundThread.join();
	}

}
