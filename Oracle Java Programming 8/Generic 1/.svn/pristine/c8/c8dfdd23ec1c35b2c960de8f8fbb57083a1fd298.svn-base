package ua.org.ao.balobanov_d.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.org.ao.balobanov_d.GenericStorage;

public class GetElementTest {
	GenericStorage<Integer> array;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		array = new GenericStorage<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getElementTest() {
		Integer ex = 5;
		assertEquals(ex, array.getElement(4));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getElementTestException() {
		Integer ex = 5;
		assertEquals(ex, array.getElement(10));
	}

}
