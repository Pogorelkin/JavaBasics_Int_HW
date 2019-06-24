package com.epam.learningCenter.utils;


import com.epam.learningCenter.Course;
import com.epam.learningCenter.LearningCenter;
import com.epam.learningCenter.Student;

import java.util.LinkedList;

public class LCStudentOperImpl implements LCStudentOperations {
    private LearningCenter learningCenter;
    private Student student;

    public LCStudentOperImpl() {

    }

    public LCStudentOperImpl(Student student) {
        this.student = student;
    }

    public Integer calcHoursLeft(Student student) {
            Integer hrs = 0;
            Integer marksN = 0;
        for (Course obj: student.getCourses()) {
            hrs += obj.getHourAmount();
        }

        for (Integer mark: student.getMarks()) {
            if (mark != 0)
            hrs --;
        }

        return hrs;
    }

    public double calcAverageMark(Student student) {
        Integer marksAmount = 0;
        double avg = 0;
        Integer sum = 0;
        for (Integer mark: student.getMarks())
        {
            sum += mark;
            marksAmount++;
        }

        return sum.doubleValue() / marksAmount.doubleValue();
    }

    public String calcExpulsionPossibility(Student student) {
        if (calcAverageMark(student) <= 4.5 ){ return student.getFirstName() + " is doing bad (FeelsBadMan. " +
                     " Possibility of expulsion ";}
            else { return student.getFirstName() + " is doing well(FeelsGoodMan) " ;}
    }

    //print sorted list of students. oreder by avg, order by hrsleft


    public LinkedList<Student> sortMarksByHours(LinkedList<Student> studentsList) {

        return null;
    }

    public LinkedList<Student> sortMarksByAverage() {
        return null;
    }
}
