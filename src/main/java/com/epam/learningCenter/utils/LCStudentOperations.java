package com.epam.learningCenter.utils;

import com.epam.learningCenter.*;
import java.util.LinkedList;

public interface LCStudentOperations {
    Integer calcHoursLeft(Student student);
    double calcAverageMark(Student student);

    String calcExpulsionPossibility(Student student);

    LinkedList<Student> sortMarksByHours(LinkedList<Student>); //issue
    LinkedList<Student> sortMarksByAverage(LinkedList<Student>);

}
