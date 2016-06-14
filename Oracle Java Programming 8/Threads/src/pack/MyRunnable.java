package pack;

public class MyRunnable implements Runnable {
	
	private Thread t;
	
	public MyRunnable()
	{
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		
		while((System.currentTimeMillis() - start) <= 5000)
		{
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
