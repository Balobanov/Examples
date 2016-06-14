package pack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteLog {
	
	public synchronized static void writeLog(File f)
	{
		try(
				FileWriter fos = new FileWriter("log.txt", true);
				BufferedWriter bos = new BufferedWriter(fos);
				PrintWriter pw = new PrintWriter(bos)) 
			{
				pw.println(f.getAbsolutePath());
			} 
			catch (Exception e) 
			{
				
			}
	}
}
