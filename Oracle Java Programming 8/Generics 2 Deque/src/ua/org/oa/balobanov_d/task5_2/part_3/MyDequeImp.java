package ua.org.oa.balobanov_d.task5_2.part_3;

import java.util.Iterator;

public class MyDequeImp<E> implements MyDeque<E>{

	private class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node<E> getNext()
        {
            return next;
        }
        
        public E getData()
        {
            return data;
        }
        
        public void setNext(Node<E> next)
        {
            this.next = next;
        }

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
        
		public String toString(){
			return "toString для элемента " + data + ". ";
		}

		public void setData(E data) {
			this.data = data;
		}
		
		
        
    }
    
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;
    
    
	@Override
	public void addFirst(E e) {
		
		Node<E> newNode = newNode(e);
		
		if(isEmpty())
		{
			firstNode = lastNode = newNode;
			size++;
		}
		else
		{
			newNode.setNext(firstNode);
			firstNode.setPrev(newNode);
			firstNode = newNode;
			size++;
		}
		
	}

	@Override
	public void addLast(E e) {
		
		Node<E> newNode = newNode(e);
		
		if(isEmpty())
		{
			firstNode = lastNode = newNode;
			size++;
		}
		else
		{
			lastNode.setNext(newNode);
			newNode.setPrev(lastNode);
			lastNode = newNode;
			size++;
		}
		
	}

	@Override
	public E removeFirst() {
		E data;

        if(isEmpty())
           return null;
        
        else
            if(firstNode == lastNode)
            {
            	data = firstNode.getData();
                firstNode = lastNode = null;
                size--;
                return data;
            }
        else
        {
        	data = firstNode.getData();
            firstNode = firstNode.getNext();
            firstNode.setPrev(null);
            size--;
            return data;
        }
	}

	@Override
	public E removeLast() {
		E data;

        if(isEmpty())
           return null;
        
        else
            if(firstNode == lastNode)
            {
            	data = firstNode.getData();
                firstNode = lastNode = null;
                size--;
                return data;
            }
        else
        {
        	data = lastNode.getData();
        	lastNode = lastNode.getPrev();
        	lastNode.setNext(null);
            size--;
            return data;
        }
	}

	@Override
	public E getFirst() {
		if(!isEmpty())
		return firstNode.getData();
		else
			return null;
	}

	@Override
	public E getLast() {
		if(!isEmpty())
			return lastNode.getData();
			else
			return null;
	}

	@Override
	public boolean contains(Object o) {
		
		if(!isEmpty())
		{
			if(firstNode == lastNode)
			{
				return firstNode.getData().equals(o);
			}
			
			Node<E> tempNode = firstNode;
			
			while(tempNode != null)
			{
				if(tempNode.getData().equals(o))
					return true;
				tempNode = tempNode.getNext();
			}
		}
		
		return false;
	}

	@Override
	public void clear() {
		firstNode = lastNode = null;
		size=0;
	}

	@Override
	public Object[] toArray() {
		int index = 0;
		
		if(!isEmpty())
		{
			Object array[] = new Object[size];
			Node<E> tempNode = firstNode;
			
			while(tempNode != null)
			{
				array[index++] = tempNode.getData();
				tempNode = tempNode.getNext();
			}
			
			return array;
		}
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean containsAll(MyDeque<? extends E> deque) {
		
		if(!isEmpty())
		{
			Object temp[] = deque.toArray(); // Получить "копию" deque

			// Сравнить элемент temp через функцию contains
			for (int i = 0; i < temp.length; i++) {
				if( !this.contains(temp[i]))
					return false;
			}
			return true;
		}
		
		return false;
	}
	
	public boolean isEmpty()
    {
        return size <= 0;
    }
	
	// Создать новый узел
    private Node<E> newNode(E data)
    {
    	return new Node<E>(data);
    }
    
    
    @Override
    public String toString()
    {
        /*String s = "";
        if(!isEmpty())
        {
            
            Node<E> currentRef;
            currentRef = firstNode;
            while(currentRef != null)
            {
                s = s.concat("[" + currentRef.getData() + "] ");
                currentRef = currentRef.getNext();
            }
        }
        return s;*/
    	
    	 String s = "В Deque. ";
        if(!isEmpty())
        {
            
            Node<E> currentRef;
            currentRef = firstNode;
            while(currentRef != null)
            {
                s = s.concat(currentRef.toString());
                currentRef = currentRef.getNext();
            }
        }
        return s;
    }
    
    public String printToHead()
    {
        String s = "В Deque. ";
        if(!isEmpty())
        {
            
            Node<E> currentRef;
            currentRef = lastNode;
            while(currentRef != null)
            {
                s = s.concat("[" + currentRef.getData() + "] ");
                currentRef = currentRef.getPrev();
            }
        }
        return s;
    }

    
    /////////////////////////////////////////////////////////////////////
    //////////////////////Итератор///////////////////////////////////////
	@Override
	public Iterator<E> iterator() {
		return new IteratorImp();
	}
	
	private class IteratorImp implements Iterator<E>
	{
		private Node<E> iterator;
		protected Node<E> forDelete;
		protected boolean wasNext = false;
		
		public IteratorImp(){
			iterator = firstNode;
		}
		
		@Override
		public boolean hasNext() {
			if(iterator != null)
			{
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			E data;
			data = iterator.getData();
			forDelete = iterator;
			iterator = iterator.getNext();
			wasNext = true;
			return data;
		}
		
		@Override
		public void remove() {
			if(wasNext == false)
				throw new IllegalStateException();
			else
			{
				if(forDelete.getPrev() == null)
				{
					removeFirst();
					wasNext = false;
				}
				else
				if(iterator == null)
				{
					removeLast();
					wasNext = false;
				}
				else
				{
					forDelete.getPrev().setNext(iterator);
					iterator.setPrev(forDelete.getPrev());
					size--;
					wasNext = false;
				}
			}
		}
	}

	
	//////////////////////////////////////////////////////////////////////
	////////////////////////ListIterator//////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	@Override
	public ListIterator<E> listIterator() {
		return new ListIteratorImpl();
	}
	
	private class ListIteratorImpl extends IteratorImp implements ListIterator<E> 
	{

		private Node<E> ListIterator;
		
		public ListIteratorImpl() {
			ListIterator = lastNode;
		}

		@Override
		public boolean hasPrevious() {
			if(ListIterator != null)
			{
				return true;
			}
			return false;
		}

		@Override
		public E previous() {
			E data;
			data = ListIterator.getData();
			forDelete = ListIterator;
			ListIterator = ListIterator.getPrev();
			this.wasNext = true;
			return data;
		}

		@Override
		public void set(E e) {
			if(wasNext == false)
				throw new IllegalStateException();
			else
			{
				if(ListIterator == null)
					firstNode.setData(e);
				else
					ListIterator.getNext().setData(e);
			}
			wasNext = false;
		}
		
		@Override
		public void remove() {
			if(wasNext == false)
				throw new IllegalStateException();
			else
			{
				if(forDelete.getNext() == null)
				{
					removeLast();
					wasNext = false;
				}
				else
				if(ListIterator == null)
				{
					removeFirst();
					wasNext = false;
				}
				else
				{
					forDelete.getNext().setPrev(ListIterator);
					ListIterator.setNext(forDelete.getNext());
					size--;
					wasNext = false;
				}
			}
		}
	}
}