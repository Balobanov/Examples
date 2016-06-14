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

public class AverageGradeInSemesterTest {
	   
    Student student;
    List<Exam> list;
    
    
    public AverageGradeInSemesterTest() {
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
        list.add(new Exam("WEB", 3, 2015, 10));
        student = new Student("Denis", "Balobanov", "course 6", 
                "KIT", list);
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void AverageGradeInSemester() throws StudentErrorsException
   {
       float expected = (float)(1 + 2 + 3) / 3.0f;
       assertEquals(expected, student.averageGradeInSemester(10), 0.5);
   }
   
   @Test(expected = StudentErrorsException.class)
   public void AverageGradeInSemesterException() throws StudentErrorsException
   {
       float expected = (float)(1 + 2 + 3) / 3.0f;
       assertEquals(expected, student.averageGradeInSemester(9), 0.5);
   }
  
}