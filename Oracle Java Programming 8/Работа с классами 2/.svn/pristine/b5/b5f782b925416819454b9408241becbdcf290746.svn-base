package ua.org.ao.balobanov.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import ua.org.ao.balobanov.*;

public class AddGradeTest {
    
    Student student;
    List<Exam> list;
    public AddGradeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(new Exam("SII", 1, 2015, 10));
        list.add(new Exam("Neuro Net", 2, 2015, 10));
        list.add(new Exam("WEB", 2, 2015, 10));
        student = new Student("Denis", "Balobanov", "course 6", 
                "KIT", list);
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void addGrade() throws StudentErrorsException
   {
       int expexted = list.size()+1;
       student.addGrade("Oracle", 5, 5, 10);
        
       assertEquals(expexted, list.size() , 0.1);
   }
   
   @Test(expected = StudentErrorsException.class)
   public void addGradeException() throws StudentErrorsException
   {
       int expexted = list.size()+1;

       // Не добавит. Такой уже есть
       student.addGrade("WEB", 2, 2015, 10);
        
       assertEquals(expexted, list.size() , 0.1);
   }
}
