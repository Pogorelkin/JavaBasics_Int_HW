package com.epam.learningCenter;

import java.util.*;


public class Student {
    private String firstName;
    private String getFirstName;
    private ArrayList<Integer> marks = new ArrayList<Integer>();
    private LinkedList<Course> courses = new LinkedList<Course>();

    public Student(String firstName, String getFirstName) {
        this.firstName = firstName;
        this.getFirstName = getFirstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGetFirstName() {
        return getFirstName;
    }

    public void setGetFirstName(String getFirstName) {
        this.getFirstName = getFirstName;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public void addMark(Integer mark) {
        this.marks.add(mark);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public LinkedList<Course> getCourses() {
        return courses;
    }

    public Integer getHours() {
        Integer hrs = 0;
        Integer marksN = 0;
        for (Course obj : this.getCourses()) {
            hrs += obj.getHourAmount();
        }

        for (Integer mark : this.getMarks()) {
            if (mark != 0)
                hrs--;
        }

        return hrs;
    }

    public double calcAverageMark() {
        Integer marksAmount = 0;
        double avg = 0;
        Integer sum = 0;
        for (Integer mark : this.getMarks()) {
            sum += mark;
            marksAmount++;
        }

        return sum.doubleValue() / marksAmount.doubleValue();
    }
}

