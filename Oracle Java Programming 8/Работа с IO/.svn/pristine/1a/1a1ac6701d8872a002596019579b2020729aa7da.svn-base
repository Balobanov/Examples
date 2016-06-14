package ua.org.oa.balobanov_d;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Задание 1-2
		 */
		/*String file = "intFile.txt";
		FileUtilites.createAndFillFileRandomInt(file, 100);
		FileUtilites.printBinaryFile(file);
		FileUtilites.sortBinaryFile(file);
		FileUtilites.printBinaryFile(file);*/
		
		/*
		 * Задание 3
		 */
		/*String file2 = "students.txt";
		FileUtilites.readTextFile(file2);*/
		
		/*
		 * Задание 4
		 */
		/*String file3 = "someText.txt";
		FileUtilites.readFileAndReplaceWords(file3);*/
		
		/*
		 * Задание 5
		 */
		/*String from = "forCopy.txt";
		String to = "forCopy2.txt";
		FileUtilites.copyFilestest(from, to);*/
		
		/*
		 * Задание 6
		 */
		String file5 = "stud.txt";
		Group g = new Group(Arrays.asList(new Student("Shao","Kann"), 
				new Student("Mr","Smile"),
				new Student("Noob","Saibot"),
				new Student("Mr","Smoke")));
		
		try(FileOutputStream fos = new FileOutputStream(file5);
				ObjectOutputStream ous = new ObjectOutputStream(fos))
		{
			ous.writeObject(g);
			ous.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		g = null;
		try(FileInputStream fis = new FileInputStream(file5);
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
			g = (Group) ois.readObject();	
		}
		catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(g);
	}

}
