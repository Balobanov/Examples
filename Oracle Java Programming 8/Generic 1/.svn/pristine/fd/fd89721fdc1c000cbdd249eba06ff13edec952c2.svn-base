package ua.org.ao.balobanov_d.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.org.ao.balobanov_d.GenericStorage;

public class ResizeArray {

	GenericStorage<Integer> array;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		array = new GenericStorage<>(3);
		array.add(1);
		array.add(2);
		array.add(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void resizeArray() {
		
		int expecteds_capacity = 6;
		array.add(1);
		
		assertEquals(expecteds_capacity, array.capacity());
	}

}
