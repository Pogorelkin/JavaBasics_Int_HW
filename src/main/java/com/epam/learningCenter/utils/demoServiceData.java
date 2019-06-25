package com.epam.learningCenter.utils;

import com.epam.learningCenter.Course;
import com.epam.learningCenter.LearningCenter;
import com.epam.learningCenter.Student;

import java.util.Arrays;
import java.util.LinkedList;

public class demoServiceData implements demoService {



    @Override
    public void startDemo() {
        LCStudentOperImpl operations = new LCStudentOperImpl();
        LearningCenter learningCenter = new LearningCenter();
        LinkedList<Student> studentsList = new LinkedList<Student>();
        //student Ivanov Ivan
        LinkedList<Integer> marks = new LinkedList<>(Arrays.asList(3,4,2,5,3,3));
        LinkedList<Course> courses = new LinkedList<>(Arrays.asList(new Course("Java Servlets", 16),
                                                                    new Course("Struts Framework", 24),
                                                                    new Course("Spring Framework",48),
                                                                    new Course("Hibernate", 20)));
        learningCenter.addStudent(new Student("Ivan", "Ivanov", "J2EE Developer", marks, courses));


        //Petrov Petr
        marks = new LinkedList<>(Arrays.asList(4,5,3,2,3,3,5,5));
        courses = new LinkedList<>(Arrays.asList(new Course("Java technologies review", 8),
                new Course("JFC/Swing library", 16),
                new Course("JDBC technology",16),
                new Course("JAX technology",52),
                new Course("Common libraries", 44)));
        learningCenter.addStudent(new Student("Petr", "Petrov", "Java Developer", marks, courses));

        //Dmitry Dmitriev
        marks = new LinkedList<>(Arrays.asList(4,5,5,5));
        courses = new LinkedList<>(Arrays.asList(new Course("Some course1 ", 8),
                new Course("Some course2", 8),
                new Course("Some course3",8),
                new Course("Some course4",8),
                new Course("Some course5", 8)));
        learningCenter.addStudent(new Student("Dmitry", "Dmitriev", ".NET Developer", marks, courses));

        System.out.println("\n");
        for (Student student: learningCenter.getStudentList()) {
            System.out.println("Expulsion possibility: " + operations.calcExpulsionPossibility(student));
            operations.printStudentWithDecision(student);
        }
        System.out.println("\nSort students by average mark");
        studentsList = operations.sortStudentsByAverage(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(student+"\n");
        }

        System.out.println("\nSort students by hours_left amount");
        studentsList = operations.sortStudentsByHours(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(student+"\n");
        }

        System.out.println("\nFilter bad students");
        studentsList = operations.filterStudentsLosers(learningCenter.getStudentList());
        for (Student student: studentsList) {
            System.out.println(student+"\n");
        }
    }
}
