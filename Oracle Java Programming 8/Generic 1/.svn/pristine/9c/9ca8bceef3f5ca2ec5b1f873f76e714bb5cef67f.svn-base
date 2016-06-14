package ua.org.ao.balobanov_d.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.org.ao.balobanov_d.GenericStorage;

public class DeleteNullPointers {
	
	GenericStorage<Integer> array;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		array = new GenericStorage<>(5);
		array.add(1);
		array.add(2);
		array.add(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Вызыается после удаления элемента
	// чтобы "захлопнуть" пустую ячейку
	@Test
	public void deleteNullPointers() {
		Object expecteds[] = {new Integer(1), new Integer(3)};
		array.delete(1);
		Object actual[] = array.getAll(); 
		
		assertArrayEquals(expecteds, actual);
	}

}
