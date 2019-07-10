package com.epam.learningcenter.utils;

import com.epam.learningcenter.Course;
import com.epam.learningcenter.LearningCenter;
import com.epam.learningcenter.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;

public class DemoServiceData implements DemoService {

    @Override
    public void startDemo() {
        LCStudentOperImpl operations = new LCStudentOperImpl();
        LearningCenter learningCenter = new LearningCenter();
        LinkedList<Student> studentsList;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //input student Ivanov Ivan
        LinkedList<Integer> marks = new LinkedList<>(Arrays.asList(3,4,2,5,3,3));
        LinkedList<Course> courses = new LinkedList<>(Arrays.asList(new Course("Java Servlets", 16),
                                                                    new Course("Struts Framework", 24),
                                                                    new Course("Spring Framework",48),
                                                                    new Course("Hibernate", 20)));
        learningCenter.addStudent(new Student("Ivan", "Ivanov", "J2EE Developer", marks, courses, LocalDate.parse("26/06/2019", formatter)));


        marks = new LinkedList<>(Arrays.asList(4,5,3,2,3,3,5,5));
        courses = new LinkedList<>(Arrays.asList(new Course("Java technologies review", 8),
                new Course("JFC/Swing library", 16),
                new Course("JDBC technology",16),
                new Course("JAX technology",52),
                new Course("Common libraries", 44)));
        learningCenter.addStudent(new Student("Petr", "Petrov", "Java Developer", marks, courses, LocalDate.parse("20/06/2019", formatter)));

        marks = new LinkedList<>(Arrays.asList(4,5,5,5));
        courses = new LinkedList<>(Arrays.asList(new Course("Some course1 ", 8),
                new Course("Some course2", 8),
                new Course("Some course3",8),
                new Course("Some course4",8),
                new Course("Some course5", 8)));
        learningCenter.addStudent(new Student("Dmitry", "Dmitriev", ".NET Developer", marks, courses, LocalDate.parse("25/06/2019", formatter)));

        System.out.println("\n");
        for (Student student: learningCenter.getStudentList()) {
            System.out.println("Expulsion possibility: " + operations.calcExpulsionPossibility(student));
            operations.printStudentWithDecision(student);
        }
        System.out.println("\nSort students by average mark(asc):");
        studentsList = (LinkedList<Student>) operations.sortStudentsByAverage(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(String.format("%s, %.2f ",student,student.calcAverageMark()));
        }

        System.out.println("\nSort students by daysLeft amount (asc):");
        studentsList = (LinkedList<Student>) operations.sortStudentsByDays(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(student + " " + student.getDaysLeft() );
        }

        System.out.println("\nFilter bad students");
        studentsList = (LinkedList<Student>) operations.filterStudentsLosers(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(student+" ");
        }
    }
}
