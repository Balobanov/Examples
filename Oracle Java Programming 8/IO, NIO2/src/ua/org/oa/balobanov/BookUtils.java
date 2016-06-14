package ua.org.oa.balobanov;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookUtils {

	public static void saveBookToFile(Book book, String fileName, boolean append)
	{
		List<Book> list = null;
		if(append)
		{
			list = readFromSerializableFile(fileName);
		}
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream ous = new ObjectOutputStream(fos))
		{
			
			if(list != null)
					for (Book book1 : list) {
						ous.writeObject(book1);
					}
			
			ous.writeObject(book);
			ous.flush();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void saveBookToFile(List<Book> books, String fileName, boolean append)
	{
		List<Book> list = null;
		if(append)
		{
			list = readFromSerializableFile(fileName);
		}
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream ous = new ObjectOutputStream(fos))
		{
			if(list != null)
				for (Book book1 : list) {
					ous.writeObject(book1);
				}
			
			for (Book book : books) {
				ous.writeObject(book);
			}
			ous.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static List<Book> readFromSerializableFile(String fileName)
	{
		List<Book> books = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
				while(true)
				{
					books.add((Book) ois.readObject());
				}
		}
		catch(IOException | ClassNotFoundException e)
		{
			//System.out.println("Файл загружен.");
		}
		return books;
	}
	
	public static List<Book> readFromTextFile(String fileName)
	{
		List<Book> books = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis))
		{
				while(scan.hasNextLine())
				{
					StringTokenizer st = new StringTokenizer(scan.nextLine(), ";");
					books.add(new Book(st.nextToken(),st.nextToken(), Integer.parseInt(st.nextToken())));
				}
		}
		catch(Exception e)
		{
			//System.out.println("Файл загружен.");
		}
		return books;
	}
}
