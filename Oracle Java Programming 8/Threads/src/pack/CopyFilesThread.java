package pack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFilesThread implements Runnable
{
	
	File fromCopy;
	File toCopy;
	
	public CopyFilesThread(File fromCopy, File toCopy) {
		this.fromCopy = fromCopy;
		this.toCopy = toCopy;
	}
	
	@Override
	public void run() {
		
		String dir;
		
		dir = fromCopy.getAbsolutePath().substring(
				fromCopy.getAbsolutePath().indexOf("\\"), 
				fromCopy.getAbsolutePath().lastIndexOf("\\")
				);
		File dirExist = new File (toCopy + dir + "\\");
		
		if(!dirExist.exists())
			try {
				Files.createDirectories(dirExist.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		System.out.println();
		
		try(FileInputStream fis = new FileInputStream(fromCopy);
			BufferedInputStream bis = new BufferedInputStream(fis);
				
			FileOutputStream fos = new FileOutputStream(toCopy + dir + "\\" + fromCopy.getName());
			BufferedOutputStream bos = new BufferedOutputStream(fos)) 
		{
			int b;
			while((b = bis.read()) != -1)
				bos.write(b);
		} 
		catch (Exception e) 
		{
			
		}
	}
	
}