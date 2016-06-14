package ua.org.oa.balobanov;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		
		/*
		 * 
		 * ЧАСТЬ 1
		 * 
		 */
		
		List<Book> list;
		
		/*
		 * Считать данные в текстовой форме
		 */
		System.out.println(BookUtils.readFromTextFile("booksText"));
		
		/*
		 * Сериализовать список в файл
		 */
		BookUtils.saveBookToFile(Arrays.asList(new Book("Horstmann", "Java 7, tom 1", 2014),
				new Book("Horstmann", "Java 7, tom 2", 2014),
				new Book("Shildt", "Java 8", 2015)), "books.txt", false);
		
		/*
		 * Прочитать сериализованные объекты
		 */
		list = BookUtils.readFromSerializableFile("books.txt");
		System.out.println(list);
		
		/*
		 * Дописать в конец файла сериальзованные объекты.
		 * Последний параметр saveBookToFile указывает нужно ли дописывать в конец.
		 * дописать - true
		 */
		BookUtils.saveBookToFile(Arrays.asList(new Book("Horstmann", "Java 7, tom 1", 2014),
				new Book("Horstmann", "Java 7, tom 2", 2014),
				new Book("Shildt", "Java 8", 2015)), "books.txt", true);
		list = BookUtils.readFromSerializableFile("books.txt");
		System.out.println(list);
		
		/*
		 * Сохранить одну запись в файл
		 */
		BookUtils.saveBookToFile(new Book("head first", "Java 7 programming", 2014), "books.txt", true);
		list = BookUtils.readFromSerializableFile("books.txt");
		System.out.println(list);
		
		/*
		 * перезаписать файл и сохранить одну запись
		 */
		BookUtils.saveBookToFile(new Book("head first", "Java 7 programming", 2014), "books.txt", false);
		list = BookUtils.readFromSerializableFile("books.txt");
		System.out.println(list);
		
		
		
		/*
		 * 
		 * ЧАСТЬ 2
		 * 
		 */
		
		String command = "";
		scan = new Scanner(System.in);
		String path;
		String name;
		
		while(!command.equals("exit"))
		{
			System.out.println("Выберите команду:");
			FileUtils.commands();
			command = scan.next();
			
			switch (Integer.parseInt(command)) {
			case 1:
				System.out.println("Введите путь к файлу: ");
				path = scan.next();
				
				System.out.println("Введите новое имя: ");
				name = scan.next();
				
				FileUtils.rename(path, name);
				break;
			
			case 2:
				System.out.println("Введите путь к файлу: ");
				path = scan.next();
				
				System.out.println("Путь куда скопировать: ");
				name = scan.next();
				
				FileUtils.copy(path, name);
				break;
				
			case 3:
				System.out.println("Введите путь к файлу: ");
				path = scan.next();
				FileUtils.delete(path);
				break;
				
			case 4:
				System.out.println("Введите путь где создать файл вместе с именем: ");
				path = scan.next();
				FileUtils.create(path);
				break;

			case 5:
				System.out.println("Введите пусть к каталогу который надо просмотреть: ");
				path = scan.next();
				FileUtils.showAllFiles(path);
				break;

			default:
				break;
			}
		}
		
		
	}

}
