���������. ��������������� �������.

	
?Task 5.1

���������:

1. �������� ����� ��� ���� �������: ua.org.oa.<JIRALOGIN>.task5_1

2.������ ��� ������ � ��������� ����.

3. ��� ���������� ������� ���������� ������������ � ���������� ���������� ���������� Comparable

�������:

1.1. ������� ����� ������������, � ������� ���������� 2-3 ����.

1.2. ������� ����� ����������, � ������� ���������� 2-3 ����. ����� ��������� ������ ������������� ��������� Comparator.

1.3. ������� ����������� �����, ��� ����������� ������������� (�� compareTo()) �������� � ������� ��������. ������������������ ������ ������ �� ������� �������� ���� Integer, String, ������������ (������ ���� ������ ����������), ����������.

Task 5.2

���������:

1. �������� ����� ��� ���� �������: ua.org.oa.<JIRALOGIN>.task5_2

2. ������� ������� �� ���������� ������, ������ ����� ���������� �� ������; ���, ������� ��������� � ����� ����� ������ ������������� � ��������� ������.

3. ������ ��� ������ � ��������� ����.

4. ������������� ����������� � ���������� ������ java.util.LinkedList

�������:

����� �1 (����� ua.org.oa.<JIRALOGIN>.task5_2.part1)

1.1. ������� generic ��������� MyDeque (���������� ������) ���������� ����������:

public interface MyDeque<E> {

// �������� ������� � ������ ������

void addFirst(E e);

// �������� ������� � ����� ������

void addLast(E e);

// �������� ������� �� ������ ������ � ������� ���

E removeFirst();

// �������� ������� �� ����� ������ � ������� ���

E removeLast();

// �������� ������� �� ������ ������, �� ������ ���

E getFirst();

// �������� ������� �� ����� ������, �� ������ ���

E getLast();

// ���������, ���������� �� ������ o � ������

// (� ������� equals)

boolean contains(Object o);

// �������� ������

void clear();

// ������� ������ ��������� �� ������

// (�������� ��������������� ��������� ������)

Object[] toArray();

// ������� ���������� ��������� � ������

int size();

// ���������, �������� �� ������ ��� �������� ������ deque

boolean containsAll(MyDeque<? extends E> deque);

}

1.2. ������� generic ����� ��������� MyDequeImpl, ������� ��������� MyDeque (����������� ��� ������ ����������).

public class MyDequeImpl<E> implements MyDeque<E> {...}

���������: ��� ���������� ������ �������� ��������� ����� Node<E> ���������� ����:

private static class Node<E> {

// �������� �������

E element;

// ������ �� ��������� ������� ������

Node<E> next;

// ������ �� ���������� ������� ������

Node<E> prev;

Node(E element, Node<E> prev, Node<E> next) {...}

}

1.3. �������������� ����� toString ����� �������, ����� ��������� ��������� � ����:

{��������� ������ toString ��� �������� 1, ��������� ������ toString ��� �������� 2, ... }
1.4. ������� ����� Demo, ������� ������������� ������ ���� ������� ����������.

��������, ���:

public class Demo {

public static void main(String[] args) {

MyDeque<Number> deque = new MyDequeImpl<Number>();

deque.addFirst(433);

deque.addLast(8.88);

// ������������ ���� ������� MyDeque

System.out.println("list contains 433 --> " + deque.contains(433));

// ...

}

}

����� �2 (����� ua.org.oa.<JIRALOGIN>.task5_2.part2)

����������� ��������� � ����� �1 ���� � ����� part2 (������� ���������� ������ ������ ������� ����).

2.1. �������� � ���������� MyDeque<E> ������������ ���������� Iterable<E> (java.lang.Iterable).

public interface MyDeque<E> extends Iterable<E> {...}

�������� � ����� MyDequeImpl<E> �����, ������� ��������� ����� Iterable#iterator:

public Iterator<E> iterator() { return new IteratorImpl(); }

����� ������ ���������� ������ ����������� ������ IteratorImpl:

private class IteratorImpl implements Iterator<E> {

// ���������, ���� �� ��������� ������� ��� ������� ������� next

public boolean hasNext() { // ... }

// ���������� ��������� �������

public E next() { // ... }	}

// ������� �������, ������� ��� ��������� ����� ������� next

public void remove() {

/*

��������:

���� ����� ������� remove �� ��� ������ ����� next

��� ����� ������� remove ��� ������ remove (��������� ����� remove)

��������� ���������� (��� � �������� � ���):

throw new IllegalStateException();

� ������ ����� ���������� � ������� ��������������� �������

*/

}

}

2.2. ������������������ ������ ��������� � ������� ������ while � for each:

public class Demo {

public static void main(String[] args) {

MyDeque<Number> deque = new MyDequeImpl<Number>();

deque.addFirst(433);

deque.addLast(8.88);

// ...

for (Number element : deque) { System.out.println(element); }

Iterator<Number> it = deque.iterator();

while (it.hasNext())

System.out.println(it.next());

// ...

}

}

����� �3 (����� ua.org.oa.<JIRALOGIN>.task5_2.part3)

����������� ��������� � ����� �2 ���� � ����� part3 (������� ���������� ������ ������ ������� ����).

3.1. ���������� ��������� ListIterator:

public interface ListIterator<E> extends Iterator<E> { // java.util.Iterator

// ���������, ���� �� ���������� ������� ��� ������� ������� previous

boolean hasPrevious();

// ���������� ���������� �������

E previous();

// �������� �������, ������� �� ���������� ���� ��� ��������� next/previous �� ������ �������

void set(E e);

// ������� �������, ������� �� ���������� ���� ��� ��������� next/previous

void remove();

}

������ set/remove ����� ���� ������� ������ ����� next/previous. ��������� ����� (������) set/remove ������ ��������� � ������� ���������� IllegalStateException

3.2. ������� ��������� ListIterable:

public interface ListIterable<E> { ListIterator<E> listIterator(); }

3.3. �������� � ���������� MyDeque ������������ ���������� ListIterable:

public interface MyDeque<E> extends Iterable<E>, ListIterable<E> {...}

3.4. �������� � ����� MyDequeImpl �����

public ListIterator<E> listIterator() { return new ListIteratorImpl(); }

������� ���������� ������ ����������� ������ ListIteratorImpl:

private class ListIteratorImpl extends IteratorImpl implements ListIterator<E> { // ����������� ��� ������ ���������� ListIterator }

3.5. ������������������ ������ ��������� ListIterator.

public class Demo {

public static void main(String[] args) {

MyDeque<Number> deque = new MyDequeImpl<Number>();

deque.addFirst(433);

deque.addLast(8.88);

// ...

ListIterator<Number> listIt = deque.listIterator();

while (listIt.hasNext())

System.out.println(listIt.next());

while (listIt.hasPrevious())

System.out.println(listIt.previous());

// ...

}

}