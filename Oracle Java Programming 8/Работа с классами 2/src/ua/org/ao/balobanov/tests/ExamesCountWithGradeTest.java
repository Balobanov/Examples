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

public class ExamesCountWithGradeTest {
    
    Student student;
    List<Exam> list;
    
    public ExamesCountWithGradeTest() {
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
    public void ExamesCountWithGrade() throws StudentErrorsException
    {
        assertEquals(2, student.examesCountWithGrade(2), 0.1);
    }
    
    @Test(expected = StudentErrorsException.class)
    public void ExamesCountWithGradeException() throws StudentErrorsException
    {
        assertEquals(2, student.examesCountWithGrade(3), 0.1);
    }
}