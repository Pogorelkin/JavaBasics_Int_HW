package com.epam.learningcenter;

import java.util.LinkedList;

public class LearningCenter {
    private LinkedList<Student> studentList = new LinkedList<Student>();

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }
}

