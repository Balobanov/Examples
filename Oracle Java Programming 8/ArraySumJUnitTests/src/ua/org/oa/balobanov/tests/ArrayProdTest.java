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
public class ArrayProdTest {
    
    int [] array;
    public ArrayProdTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    /*
     * Начальный массив
     */
    @Before
    public void setUp() {
        array = new int[]{1,2,3,4,5};
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arrayProdTest()
    {
        int expected = (1*2*3*4*5);
        assertEquals(expected, ArrayProd.prod(array));
    }
    
    // Если будет исключение тест пройден
    @Test(expected = NullPointerException.class)
    public void arrayProdTestException()
    {
        int expected = (1*2*3*4*5);
        assertEquals(expected, ArrayProd.prod(null));
    }
    
    /*
     * Задаются правильные параметры и 
     * ожидается исключение. 
     * Если исключения нет, тест покажет ошибку. Но он считается пройден
     */
    @Test(expected = NullPointerException.class)
    public void arrayProdTestException_2()
    {
        int expected = (1*2*3*4*5);
        assertEquals(expected, ArrayProd.prod(array));
    }
}
