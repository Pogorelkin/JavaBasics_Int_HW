package com.epam.calculator;

import java.util.Scanner;

public class CalcDemoImpl implements CalcDemo {
    @Override
    public void startDemo() {
        CustomParser parser = new ParserImpl();

        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        input = scanner.nextLine();
        System.out.println("\ninput");


        parser.parseString(input);



    }
}
