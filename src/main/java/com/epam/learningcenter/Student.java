package com.epam.learningcenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static java.time.temporal.ChronoUnit.DAYS;

//import static java.time.temporal.ChronoUnit.DAYS;


public class Student {
    private String firstName;
    private String lastName;
    private String curriculum;
    private LinkedList<Integer> marks = new LinkedList<>();
    private LinkedList<Course> courses = new LinkedList<>();
    //private Date start_date;
    private LocalDate start_date;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String curriculum, LinkedList<Integer> marks, LinkedList<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.curriculum = curriculum;
        this.marks = marks;
        this.courses = courses;
    }

    public Student(String firstName, String lastName, String curriculum, LinkedList<Integer> marks, LinkedList<Course> courses, LocalDate start_date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.curriculum = curriculum;
        this.marks = marks;
        this.courses = courses;
        this.start_date = start_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourses(LinkedList<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public LinkedList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(LinkedList<Integer> marks) {
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

        for (Course obj : this.getCourses()) {
            hrs += obj.getHourAmount();
        }

        for (Integer mark : this.getMarks()) {
            if (mark != 0)
                hrs-=8;
        }
        return hrs;
    }

    public Long getCourcesDurationInDays(){
        Long hrs = new Long(0);
        for (Course obj : this.getCourses()) {
            hrs += obj.getHourAmount();
        }
        return hrs%8 == 0 ? hrs/8 : hrs/8+1;
    }

    public long getDaysLeft() {
       Long daysDifference = DAYS.between(start_date,LocalDateTime.now());
        return daysDifference <= (getCourcesDurationInDays()) ? (getCourcesDurationInDays()-daysDifference) : 0;
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

    @Override
    public String toString() {
        return firstName + lastName ;
    }
}

