package ua.org.oa.balobanov_d.task5_2.part_2;

public interface MyDeque<E> extends Iterable<E>{

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