package ua.org.oa.balobanov;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class FileUtils {
	
	public static void commands()
	{
		System.out.println("1. �������������");
		System.out.println("2. ����������");
		System.out.println("3. �������");
		System.out.println("4. �������");
		System.out.println("5. ����������� ����� � �����");
	}
	
	public static void rename(String path, String newName)
	{
		File f = new File(path);
		if(f.exists() && f.isFile())
		{
			/*
			 * @param path
			 * �� ��������� path ����� ���� �������� ��� �����.
			 * � ����� ���� ������������� ����� ��� � ���������� ������� �����
			 *
			 */
			f.renameTo(new File(f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("\\")+1) + 
					newName + f.getName().substring(f.getName().lastIndexOf("."), f.getName().length())));
			System.out.println("���� ������������.");
		}
		else
		{
			System.out.println("���� �� ������.");
		}
	}
	
	public static void copy(String from, String to)
	{
		File f1 = new File(from);
		File f2 = new File(to + f1.getName());
		if(f1.exists())
		{
				try {
					// �������� ����
					Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("���� ����������.");
		}
	}
	
	
	public static void delete(String file)
	{
		File f = new File(file);
		if(f.exists() && f.isFile())
		{
			f.delete();
		}
	}
	
	public static void create(String file)
	{
		try {
			Files.createFile(Paths.get(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void showAllFiles(String root)
	{
		
		File dir = new File(root);
		File [] files;
		
		if(dir.isDirectory())
		{
			/*
			 * ���� dir ��� ������� �������� ������ ������ � ���
			 */
			files = dir.listFiles();
			/*
			 * ���� ������� �� ������ ��������� ������ ����.
			 * 
			 */
			if(files != null)
			for (File file : files) {
				/*
				 * ���� file ������� �������� ���������� ������� � ����� ���� �����
				 */
				if(file.isDirectory())
				{
					showAllFiles(file.getAbsolutePath());
				}
				else
				{
					if(file.isFile())
					{
						System.out.println(file.getAbsolutePath());
					}
				}
			}
		}
	}
}
