package ua.org.oa.balobanov_d.task5_2.part_3;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		MyDequeImp<Number> deque = new MyDequeImp<>();

		for (int i = 1; i <= 10; i++) {
			deque.addLast(i);
		}
		
		ListIterator<Number> li = deque.listIterator();
		
		while(li.hasPrevious())
		{
			System.out.println(li.previous());
		}
		
		ListIterator<Number> li2 = deque.listIterator();
		
		while(li2.hasPrevious())
		{
			li2.previous();
			li2.set(50);
		}
		System.out.println(deque);
		
		ListIterator<Number> li3 = deque.listIterator();
		int i = 1;
		while(li3.hasPrevious())
		{
			li3.previous();
			if(i%2==0)
			li3.remove();
			i++;
		}
		System.out.println(deque);
	}

}
