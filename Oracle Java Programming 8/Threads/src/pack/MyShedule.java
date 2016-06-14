package pack;

import java.util.Map;
import java.util.Map.Entry;

public class MyShedule implements Runnable{

	private Map<String, Long> map;
	private Thread t;
	
	
	
	/**
	 * @param map
	 */
	public MyShedule(Map<String, Long> map) {
		this.map = map;
		t = new Thread(this);
		t.start();
	}



	@Override
	public void run() {
		
		for (Entry<String, Long> en : map.entrySet()) {
			System.out.println(en.getKey());
			try {
				Thread.sleep(en.getValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
