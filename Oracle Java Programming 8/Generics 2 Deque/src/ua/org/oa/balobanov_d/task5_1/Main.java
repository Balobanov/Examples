package ua.org.oa.balobanov_d.task5_1;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		
		Integer i[] = {1, 2, 9, 5, 6 ,7};
		System.out.println(Collections.max(Arrays.asList(i)));
		
		String  s[] = {"B", "N", "A", "T", "R", "X"};
		System.out.println(Collections.max(Arrays.asList(s)));
		
		
		// Ошибка, не реализует Comparable
		/*Car c[] = {new Car(Color.BLACK, 250, 4), 
				new Car(Color.WHITE, 200, 4), 
				new Car(Color.GREEN, 200, 2), 
				new Car(Color.GRAY, 350, 12),};
		System.out.println(Collections.max(Arrays.asList(c)));*/
		
		Computer comp[] = {
				new Computer(5000, "Titan GTX", "2 Tb"),
				new Computer(3900, "9600 GT", "1 Tb"),
				new Computer(6000, "Radeon 9500", "5 Tb"),
				new Computer(7000, "Titan GTX x2", "6 Tb")};
		System.out.println(Collections.max(Arrays.asList(comp)));
		
	}

}
