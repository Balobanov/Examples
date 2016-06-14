/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.ao.balobanov;

/**
 * Класс Экзамена. 
 * @author DENNNN
 */
public class Exam {
    private String nameExam;
    private int grade; // Оценка за экзамен
    private DateExam date; // Внутренний класс. Содержит дату сдачи экзамена

    // Конструктор. Устанавливает название экзамена, оценку и дату сдачи. Семестр и год.
    public Exam(String nameExam, int grade, int yaer, int semester) {
        this.nameExam = nameExam;
        this.grade = grade;
        this.date = new DateExam(yaer, semester);
    }

    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public DateExam getDate() {
        return date;
    }

    public void setDate(DateExam date) {
        this.date = date;
    }
    
    // Класс содержит дату сдачи экзамена
    class DateExam
    {
        int year = 0;
        int semester = 0;

        public DateExam(int y, int s) 
        {
            year = y;
            semester = s;
        }

        public void setYearAndSemester(int y, int s)
        {
            year = y;
            semester = s;
        }

        public int getYear() {
            return year;
        }

        public int getSemester() {
            return semester;
        }
    }
    
    @Override
        public String toString()
        {
            return "Delivery Date: " + date.getYear()+ "y.. " + date.getSemester() + " semester";
        }
}