package ua.org.oa.balobanov_d.task5_2.part_1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		MyDequeImp<Number> deque = new MyDequeImp<>();
		
		System.out.println("Добавление элемента в начало");
		deque.addFirst(15);
		deque.addFirst(1.6);
		deque.addFirst(8.666);
		System.out.println(deque);
		System.out.println("-----------------------------------------");
		
		System.out.println("Добавление элемента в конец");
		deque.addLast(3);
		deque.addLast(4);
		deque.addLast(5.55);
		System.out.println(deque);
		System.out.println("-----------------------------------------");
		
		System.out.println("Удаление с начала");
		deque.removeFirst();
		System.out.println(deque);
		System.out.println("-----------------------------------------");
		
		System.out.println("Удаление с конца");
		deque.removeLast();
		System.out.println(deque);
		System.out.println("-----------------------------------------");

		System.out.println("Получить элемент с начала, без удаления");
		System.out.println(deque.getFirst());
		System.out.println("-----------------------------------------");
		
		System.out.println("Получить элемент с конца, без удаления");
		System.out.println(deque.getLast());
		System.out.println("-----------------------------------------");
		
		System.out.println("Проверить содержится элемент 1.6 в очереди");
		System.out.println(deque.contains(1.6));
		System.out.println("-----------------------------------------");
		
		System.out.println("Метод toArray");
		System.out.println(Arrays.toString(deque.toArray()));
		System.out.println("-----------------------------------------");
		
		System.out.println("Проверить содержатся элементы в очереди");
		
		MyDequeImp<Number> newdequ = new MyDequeImp<>();
		newdequ.addFirst(1.6);
		newdequ.addFirst(4);
		newdequ.addFirst(15);
		newdequ.addFirst(3);
		
		System.out.println(deque.containsAll(newdequ));
		System.out.println("-----------------------------------------");
		
		System.out.println("Очистить очередь");
		deque.clear();
		System.out.println(deque);
		System.out.println("-----------------------------------------");
	}

}
