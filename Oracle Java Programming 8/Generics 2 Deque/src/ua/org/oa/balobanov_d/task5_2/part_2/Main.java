package ua.org.oa.balobanov_d.task5_2.part_2;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		MyDequeImp<Number> deque = new MyDequeImp<>();

		for (int i = 1; i <= 10; i++) {
			deque.addLast(i);
		}
		
		Iterator<Number> it = deque.iterator();
		
		//it.remove(); ошибка
		
		/*it.next();
		it.remove(); 
		it.remove(); ошибка*/
		
		System.out.println("for each");
		for (Number number : deque) {
			System.out.print(number + " ");
		}
		
		System.out.println("\nWhile");
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		
		Iterator<Number> it2 = deque.iterator();
		System.out.println("\nwhile remove");
		while(it2.hasNext())
		{
			System.out.print(it2.next() + " ");
			it2.remove();
			System.out.println(deque);
		}
		System.out.println(deque);
	}

}
