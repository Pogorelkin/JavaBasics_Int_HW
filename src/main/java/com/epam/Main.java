package com.epam;

import com.epam.calculator.CalcDemo;
import com.epam.calculator.CalcDemoImpl;
import com.epam.learningcenter.utils.DemoService;
import com.epam.learningcenter.utils.DemoServiceData;

public class Main {

    public static void main(String[] args) {

        //Students
        DemoService testStudents = new DemoServiceData();
         testStudents.startDemo();

        //Calc
        CalcDemo testCalc = new CalcDemoImpl();
        testCalc.startDemo();
    }
    }

