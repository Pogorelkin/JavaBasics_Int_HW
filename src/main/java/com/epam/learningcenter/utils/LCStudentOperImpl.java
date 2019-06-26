package com.epam.learningcenter.utils;


import com.epam.learningcenter.LearningCenter;
import com.epam.learningcenter.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LCStudentOperImpl {

    public LCStudentOperImpl() {

    }


    public LCStudentOperImpl(Student student) {
    }

    public LCStudentOperImpl(LearningCenter learningCenter) {
    }




    public String calcExpulsionPossibility(Student student) {
        if (student.calcAverageMark() <= 4.5 ){ return student.getFirstName() + " is doing bad (FeelsBadMan). " +
                     " Possibility of expulsion ";}
            else { return student.getFirstName() + " is doing well(FeelsGoodMan) " ;}
    }

    public List<Student> sortStudentsByDays(LinkedList<Student> studentsList) {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getDaysLeft);
        studentsList.sort(studentComparator);


        return studentsList;

    }


    public List<Student> sortStudentsByAverage(LinkedList<Student> studentsList) {

        Comparator<Student> studentComparator = Comparator.comparing(obj -> obj.calcAverageMark());
        Collections.sort(studentsList,studentComparator);


        return studentsList;
    }

    public List<Student> filterStudentsLosers(LinkedList<Student> studentsList){
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

    public void printStudentWithDecision(Student student){
        Integer bestPossibleAvgMark = 0;
        Integer dayBuffer = 0;
        String decision;

        if (student.calcAverageMark() >= 4.5) {decision = "Student can continue the learning.";}
        else { dayBuffer = (int) student.getDaysLeft();
            if (dayBuffer >= 1) {
                bestPossibleAvgMark = dayBuffer * 5;
                for (Integer mark: student.getMarks()
                ) {

                    bestPossibleAvgMark += mark;
                    dayBuffer++;  //buffer marks + these that student has at the moment
                }
                bestPossibleAvgMark = bestPossibleAvgMark / dayBuffer;
                if (bestPossibleAvgMark >=4.5) {decision = "Student can continue the learning.";}
                    else {decision = "Student has to be kicked";}
            }
            else {decision = "Student has to be kicked(";}
        }

        System.out.println(String.format("%s %s : There is %s days until end of %s learning program. Average mark is %.2f Sentence: %s .",
                student.getFirstName(),student.getLastName(),student.getDaysLeft(), student.getCurriculum(), student.calcAverageMark() ,decision));



    }


}
