package com.epam.learningcenter.utils;

import com.epam.learningcenter.Student;

import java.util.LinkedList;

public interface LCStudentOperations {

    String calcExpulsionPossibility(Student student);

    LinkedList<Student> sortStudentsByDays(LinkedList<Student> students);
    LinkedList<Student> sortStudentsByAverage(LinkedList<Student> students);

}
