package ua.org.oa.balobanov.tests;

import ua.org.oa.balobanov.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DENNNN
 */
public class ArraySumTest {
    
    int [] array;
    public ArraySumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        array = new int[]{1,2,3,4,5};
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arraySumTest()
    {
        int expected = (1+2+3+4+5);
        assertEquals(expected, ArraySum.sum(array));
    }
    
    
    // Если будет исключение тест пройден
    @Test(expected = NullPointerException.class)
    public void arraySumTestException()
    {
        int expected = (1+2+3+4+5);
        assertEquals(expected, ArraySum.sum(null));
    }
    
    /*
     * Задаются правильные параметры и 
     * ожидается исключение. 
     * Если исключения нет, тест покажет ошибку. Но он считается пройден
     */
    @Test(expected = NullPointerException.class)
    public void arraySumTestException_2()
    {
        int expected = (1+2+3+4+5);
        assertEquals(expected, ArraySum.sum(array));
    }
}
