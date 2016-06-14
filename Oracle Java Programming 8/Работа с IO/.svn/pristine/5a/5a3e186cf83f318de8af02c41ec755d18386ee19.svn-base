package ua.org.oa.balobanov_d;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class FileUtilites {
	
	public static void createAndFillFileRandomInt(String file, int count)
	{
		Random e = new Random();

		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos= new DataOutputStream(bos);) {
			for (int i = 0; i < count; i++) {
				dos.writeInt(e.nextInt(count));
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void printBinaryFile(String file)
	{

		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis= new DataInputStream(bis)) {
			
			while(true)
			{
				System.out.print(dis.readInt() + " ");
			}
			
		} catch (Exception e1) {
			//e1.printStackTrace();
		}
		System.out.println();
	}
	
	public static void sortBinaryFile(String file)
	{
		List<Integer> sortInt = new ArrayList<>();
		
		/*
		 * Прочитать список в файл
		 */
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			
			while(true)
			{
				sortInt.add(dis.readInt());
			}
			
		} catch (IOException e1) {
		}
		
		Collections.sort(sortInt, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		
		// Запись отсортированного списка в файл
		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos= new DataOutputStream(bos);) {
			
			for (Integer integer : sortInt) {
				dos.writeInt(integer);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void readTextFile(String file)
	{
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				Scanner scan = new Scanner(br)) 
		{
			String s[];
			while(scan.hasNextLine())
			{
				s = scan.nextLine().split("=");
				
				if((Integer.parseInt(s[1].trim())) >= 90)
				{
					System.out.println(s[0] + " = " + s[1]);
				}
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void readFileAndReplaceWords(String file)
	{
		String text = "";
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				Scanner scan = new Scanner(br)) 
		{
			while(scan.hasNextLine())
				text = text.concat(scan.nextLine());
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * Перестановка слов
		 */
		String sentences[] = text.split("[\\.!?]");
		String sentence[]; // Предложение разбитое на слова
		String temp;
		
		if(sentences.length > 0)
		{
			for (int i = 0; i < sentences.length; i++) {
				
				sentence = sentences[i].split("[,:; \n\t]"); // Разбить предложение на слова
				
				System.out.println(sentences[i]); // Вывести старое предложение для сравнения с новым
				
				sentences[i] = ""; // стереть старое предложение
				if(sentence.length > 0) // если были слова
				{
					// пузырь сорт
					temp = sentence[0];
					sentence[0] = sentence[sentence.length-1];
					sentence[sentence.length-1] = temp;
					
					// записать новое предложение 
					for (int j = 0; j < sentence.length; j++) {
						sentences[i] += sentence[j] + " ";
					} // end inner for
					
					System.out.println(sentences[i]); // новое предложение
					System.out.println();
					
				} // end inner if
			} //end out for
		} // end if
	}

	public static void copyFilestest(String from, String to)
	{
		long start = System.currentTimeMillis();
		
		try(FileInputStream fis = new FileInputStream(from);
			BufferedInputStream bis = new BufferedInputStream(fis);
				
			FileOutputStream fos = new FileOutputStream(to);
			BufferedOutputStream bos = new BufferedOutputStream(fos);) 
		{
			int number;
			while((number = bis.read()) != -1)
			{
				bos.write(number);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		long total = System.currentTimeMillis();
		
		System.out.println("Затрачено времени с буфером: " +  (total - start) + "мс");
		
		/*
		 * Без буфера
		 */
		start = System.currentTimeMillis();
		try(FileInputStream fis = new FileInputStream(from);
				FileOutputStream fos = new FileOutputStream(to);) 
		{
			int number;
			while((number = fis.read()) != -1)
			{
				fos.write(number);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		total = System.currentTimeMillis();
		
		System.out.println("Затрачено времени без буфера: " +  (total - start) + "мс");
	}
}
