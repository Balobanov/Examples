package pack;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String arg[]) {
		//MyThread d = new MyThread();
		
		/*Map<String, Long> map = new HashMap<String, Long>();
		
		map.put("First", 1500L);
		map.put("Second", 3500L);
		map.put("Third", 100L);
		map.put("Fourth", 1000L);
		
		MyShedule sh = new MyShedule(map);*/
		
		/*File dest = new File ("D:\\PRAKTIKAAAAAAAAAAAAAAA");
		File src = new File("D:\\Docs");
		
		copyFiles(src, dest);*/
		
		//findFiles(new File("D:\\PRAKTIKAAAAAAAAAAAAAAA"), ".txt");
		new FindFilesThread(new File("D:\\"), ".txt");
		
	}
	
	
	public static void copyFiles(File dir, File dest)
	{
		File [] files;
		if(dir.isDirectory())
		{
			files = dir.listFiles();
			if(files != null)
			for (File file : files) {
				if(file.isDirectory())
				{
					copyFiles(new File(file.getAbsolutePath()), dest);
				}
				else
				{
					if(file.isFile())
					{
						new  Thread (new CopyFilesThread (file, dest)).start();
					}
				}
			}
		}
	}
	
}

