package pack;

public class MyThread extends Thread {
	
	private Thread t;
	
	public MyThread()
	{
		start();
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		
		while((System.currentTimeMillis() - start) <= 5000)
		{
			System.out.println(getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
