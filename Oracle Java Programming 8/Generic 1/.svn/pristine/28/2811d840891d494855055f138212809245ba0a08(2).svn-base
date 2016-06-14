package ua.org.ao.balobanov_d;

public class GenericStorage <T> {
	private Object[] array;
	private int size;
	private int capacity;
	
	public GenericStorage() {
		this.array = new Object[10];
		this.size = 0;
		this.capacity = 10;
	}

	public GenericStorage(int size) {
		this.array = new Object[size];
		this.size = 0;
		this.capacity = size;
	}
	
	// Добавить в конец
	public boolean add(T element)
	{
		// Если массив заполнен
		// увеличиваем его в 2 раза
		// и рекурсивно вызвать add
		if(capacity == size)
		{
			resizeArray();
			add(element);
			return true;
		}
		else
		if(capacity > 0 && capacity > size)
		{
			array[size] = element;
			size++;
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T getElement(int index) throws ArrayIndexOutOfBoundsException
	{
		if(index < 0 || index > size-1)
			throw new ArrayIndexOutOfBoundsException();
		
		return (T) array[index];
	}
	
	
	// Вернет массив элементов которые не заполнены null
	@SuppressWarnings("unchecked")
	public T[] getAll()
	{
		if(size > 0)
		{
			Object[] tempArray = new Object[size];
			for (int i = 0; i < size; i++) {
				tempArray[i] = array[i];
			}
			
			return (T[]) tempArray;
		}
		return null;
	}
	
	//Удаляет заданный объект из массива
	public void delete(T element)
	{
		int tempSize = size;
		for (int i = 0; i < tempSize; i++) {
			if(element.equals(array[i]))
			{
				array[i] = null;
				size--;
			}
		}
		deleteNullPointers();
	}
	
	// Обновляет элемент по индексу
	public void update(int index, T element)
	{
		if(index >= 0 && index <= size-1)
		{
			array[index] = element;
		}
	}
	
	//Удаляет заданный элемент по индексу
	public void delete(int index)
	{
		if(index >= 0 && index <= size-1)
		{
			array[index] = null;
			size--;
			deleteNullPointers();
		}
	}
	
	// Размер ЗАПОЛНЕННОГО МАССИВА
	public int size()
	{ 
		return size;
	}
	
	public int capacity()
	{ 
		return capacity;
	}
	
	// Сервисная функция которая увеличивает массив в 2 раза
	// если не хватает места
	private void resizeArray()
	{
		Object[] newArray = new Object[capacity*2];
		capacity *= 2;
		
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	// Сдвигает все элементы после удаления, чтобы не было пуслых мест
	private void deleteNullPointers()
	{
		Object[] newArray = new Object[capacity];
		
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null)
			{
				newArray[j] = array[i];
				j++;
			}
		}
		array = newArray;
	}
}
