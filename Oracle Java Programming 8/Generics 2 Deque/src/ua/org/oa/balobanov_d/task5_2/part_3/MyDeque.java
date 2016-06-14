package ua.org.oa.balobanov_d.task5_2.part_3;

public interface MyDeque<E> extends ListIterable<E>, Iterable<E>{

	// добавить элемент в начало списка
	void addFirst(E e);

	// добавить элемент в конец списка
	void addLast(E e);

	// получить элемент из начала списка и удалить его
	E removeFirst();

	// получить элемент из конца списка и удалить его
	E removeLast();

	// получить элемент из начала списка, не удал€€ его
	E getFirst();

	// получить элемент из конца списка, не удал€€ его
	E getLast();

	// проверить, содержитс€ ли объект o в списке
	// (с помощью equals)
	boolean contains(Object o);

	// очистить список
	void clear();

	// вернуть массив элементов из списка
	// (сохран€€ упор€доченность элементов списка)
	Object[] toArray();
	
	// вернуть количество элементов в списке
	int size();

	// проверить, содержит ли список все элементы списка deque
	boolean containsAll(MyDeque<? extends E> deque);
	
	}