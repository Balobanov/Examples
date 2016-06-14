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
public class Student {
    private String fName;
    private String lName;
    private Group group; 
    private List<Exam> exames; // ������ ��������� ������� ������ �������

    // �����������. ��������� ���, �������, ������ � ������ ���������
    public Student(String fName, String lName, Group group, List<Exam> exames) {
        this.fName = fName;
        this.lName = lName;
        this.group = group;
        this.exames = exames;
    }

    // �����������. ��������� ���, ������� � ������ ��� ������ ���������
    public Student(String fName, String lName, Group group) {
        this.fName = fName;
        this.lName = lName;
        this.group = group;
        exames = new ArrayList<>();
    }

    // �����������. ��������� ���, �������, ����, ���������. ��� ������ ���������
    public Student(String fName, String lName, String course, String faculty) {
        this.fName = fName;
        this.lName = lName;
        this.group = new Group(course, faculty);
        exames = new ArrayList<>();
    }
    
    // �����������. ��������� ���, �������, ����, ���������, ������ ���������
     public Student(String fName, String lName, String course, String faculty, List<Exam> exames) {
        this.fName = fName;
        this.lName = lName;
        this.group = new Group(course, faculty);
        this.exames = exames;
    }
    
     
     // ���������� ������������ ������ �� ��������� ��������
    public int topGrade(String nameExam)
    {
        int topgrade = 0;
            for (Exam exam : exames) 
            {
                if( exam.getNameExam().equalsIgnoreCase(nameExam))
                    if(topgrade < exam.getGrade())
                        topgrade = exam.getGrade();
                    
            }
        return topgrade;
    }
    
    //��������� ������� � ������
    //���� ����� ������� ��� ����, ������������� ����������
    //����� ������� ���������� �������� ������ � ������ �����, ��� ��� ������� 
    public void addGrade(String nameExam, int grade, int year, int semester) throws StudentErrorsException
    {
        for (Exam exam : exames) 
            {
                if(exam.getNameExam().equalsIgnoreCase(nameExam) && exam.getGrade() == grade 
                        && exam.getDate().getYear() == year && exam.getDate().getSemester() == semester)
                    throw new StudentErrorsException("Exam already exist.");
            }
        exames.add(new Exam(nameExam, grade, year, semester));
    }
    
    //������� ������� �� �����
    public void removeGrade(String nameExam)
    {
            for(int i = 0; i < exames.size(); i++ )
            {
                if(exames.get(i).getNameExam().equalsIgnoreCase(nameExam))
                {
                    exames.remove(i);
                    i = 0;
                }
            }
    }
    
    // ���������� ���������� ������� ��������� � ��������� �������
    // ���� ��������� �� ������� ������������� ����������
    public int examesCountWithGrade(int grade) throws StudentErrorsException
    {
        int count = 0;
        for (Exam exam : exames) 
            {
                if(exam.getGrade() == grade)
                  count++;
            }
        if(count == 0)
            throw new StudentErrorsException("Exam not found.");
        return count;
    }
    
    
    // ������� ������ �� �������
    // ���� ������� ����� ����������� ��� ������ �������� ���
    // ������������� ����������
    public float averageGradeInSemester(int semester) throws StudentErrorsException
    {
        int count = 0;
        float averageGrade = 0.0F;
        for (Exam exam : exames) 
            {
                if(exam.getDate().getSemester() == semester)
                {
                  count++;
                  averageGrade += exam.getGrade();
                }
            }
        if(count == 0 || averageGrade == 0)
            throw new StudentErrorsException("Invalid semester.");
        else
        return averageGrade / (float)count;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Exam> getExames() {
        return exames;
    }

    public void setExames(List<Exam> exames) {
        this.exames = exames;
    }
    
    // ������� ������ ���������� � ��������.
    @Override
    public String toString()
    {
        System.out.println("Fist name: " + this.getfName());
        System.out.println("Last name: " + this.getlName());
        System.out.print("Group: ");
        System.out.println(this.getGroup());
        
        if(exames.size() > 0)
        {
            System.out.println("Exams: ");
            int i = 1;
            for (Exam exam : exames) {
                System.out.print( i + ") " +"Exam: " + exam.getNameExam());
                System.out.print(". Grade: " + exam.getGrade());
                System.out.println(". " + exam);
                i++;
            }
        }
        else
            System.out.println("No exames yet.");
        
        return "";
    }
}

