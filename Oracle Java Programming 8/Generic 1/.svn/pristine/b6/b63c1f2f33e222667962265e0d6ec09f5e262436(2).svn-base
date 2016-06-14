package ua.org.ao.balobanov_d;

import java.util.Arrays;

public class Main {

	public static void main(String [] args)
	{
		GenericStorage<Integer> gs = new GenericStorage<>(3);
		
		gs.add(1);
		gs.add(2);
		gs.add(3);
		gs.add(4);
		gs.add(4);
		gs.add(5);
		
		System.out.println(Arrays.toString(gs.getAll()));
		
		gs.delete(1);
		System.out.println(Arrays.toString(gs.getAll()));
		
		gs.delete(new Integer(4));
		System.out.println(Arrays.toString(gs.getAll()));
		
		gs.update(0, 100);
		System.out.println(Arrays.toString(gs.getAll()));

	}
	
}
