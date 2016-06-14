package ua.org.ao.balobanov_d.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.org.ao.balobanov_d.GenericStorage;

public class DeleteTest {
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
		array.add(3);
		array.add(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deleteByIndex() {
		Object expecteds[] = {new Integer(1),new Integer(3)};
		array.delete(2);
		assertArrayEquals(expecteds, array.getAll());
	}
	
	@Test
	public void deleteT() {
		Object expecteds[] = {new Integer(1)};
		array.delete(new Integer(3));
		assertArrayEquals(expecteds, array.getAll());
	}

}
