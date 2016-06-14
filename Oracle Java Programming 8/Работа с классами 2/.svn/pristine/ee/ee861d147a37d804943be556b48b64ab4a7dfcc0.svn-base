/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.ao.balobanov;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DENNNN
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Exam> list = new ArrayList<>();
        
        list.add(new Exam("SII", 5, 2015, 10));
        list.add(new Exam("Neuro Net", 4, 2015, 10));
        list.add(new Exam("WEB", 5, 2015, 10));
        list.add(new Exam("WEB", 3, 2015, 10));
        list.add(new Exam("WEB", 4, 2015, 10)); 
        list.add(new Exam("kognitive systems", 5, 2015, 10));
        list.add(new Exam("Evolution modeling", 5, 2015, 10));
        
       Student Balobanov = new Student("Denis", "Balobanov", "6", "KIT", list);
            
       System.out.println(Balobanov);
             
        try
        {
            System.out.println( Balobanov.averageGradeInSemester(10));
        }
        catch(StudentErrorsException e)
        {
            System.out.println(e);
        }
        
        try
        {
            System.out.println(Balobanov.examesCountWithGrade(5));
        }
        catch(StudentErrorsException e)
        {
            System.out.println(e);
        }
        
        try
        {
            Balobanov.addGrade("Oracle", 5, 5, 10);
            Balobanov.addGrade("Oracle", 3, 4, 10);
        }
        catch(StudentErrorsException e)
        {
            System.out.println(e);
        }
       
        System.out.println(Balobanov.topGrade("WEB"));
        System.out.println(Balobanov);
    }
    
}
