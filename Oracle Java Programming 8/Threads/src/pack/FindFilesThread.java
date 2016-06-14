package pack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FindFilesThread implements Runnable
{
	
	File fileScr;
	String filter;
	public FindFilesThread(File file, String filter) {
		this.fileScr = file;
		this.filter = filter;
		new Thread(this).start();
	}
	
	@Override
	public void run() 
	{
		File [] files;
		if(fileScr.isDirectory())
		{
			files = fileScr.listFiles();
			if(files != null)
			for (File file : files) {
				if(file.isDirectory())
				{
					new FindFilesThread(new File(file.getAbsolutePath()), filter);
				}
				else
				{
					if(file.isFile())
					{
						if(file.getName().endsWith(filter))
						WriteLog.writeLog(file);
					}
				}
			}
		}
	}
	
}