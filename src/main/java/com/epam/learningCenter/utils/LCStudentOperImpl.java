package com.epam.learningCenter.utils;


import com.epam.learningCenter.LearningCenter;
import com.epam.learningCenter.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LCStudentOperImpl {
    private LearningCenter learningCenter;
    private Student student;

    public LCStudentOperImpl() {

    }


    public LCStudentOperImpl(Student student) {
        this.student = student;
    }

    public LCStudentOperImpl(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }




    public String calcExpulsionPossibility(Student student) {
        if (student.calcAverageMark() <= 4.5 ){ return student.getFirstName() + " is doing bad (FeelsBadMan. " +
                     " Possibility of expulsion ";}
            else { return student.getFirstName() + " is doing well(FeelsGoodMan) " ;}
    }

    public LinkedList<Student> sortStudentsByHours(LinkedList<Student> studentsList) {
        Comparator<Student> studentComparator = Comparator.comparing(obj -> obj.getHours());
        Collections.sort(studentsList,studentComparator);


        return studentsList;

    }


    public LinkedList<Student> sortStudentsByAverage(LinkedList<Student> studentsList) {

        Comparator<Student> studentComparator = Comparator.comparing(obj -> obj.calcAverageMark());
        Collections.sort(studentsList,studentComparator);


        return studentsList;
    }

    public LinkedList<Student> filterStudentsLosers(LinkedList<Student> studentsList){
         LinkedList<Student> studentList = new LinkedList<Student>();
         Integer bestPossibleAvgMark = 0;
         Integer dayBuffer = 0;

        for (Student student: studentsList) {
            //calc avg, if avg>4.5 list.add. if <4.5 then ( (hrsLeft/8*5+ marks) / amount) = bestPossible.
            // if bP >= 4.5 then add
            if (student.calcAverageMark() >= 4.5) {studentList.add(student);}
             else { dayBuffer = student.getHours()/8;
                 if (dayBuffer >= 1) {
                     bestPossibleAvgMark = dayBuffer * 5;
                     for (Integer mark: student.getMarks()
                          ) {

                         bestPossibleAvgMark += mark;
                         dayBuffer++;
                     }
                     bestPossibleAvgMark = bestPossibleAvgMark / dayBuffer;
                     if (bestPossibleAvgMark >=4.5) {studentList.add(student);}
                 }
            }
        }

        return studentList;

    }


}
