package com.epam.calculator;

import com.epam.calculator.utility.CustomParser;
import com.epam.calculator.utility.ParserImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CalcDemoImpl implements CalcDemo {
    @Override
    public void startDemo() {
        CustomParser parser = new ParserImpl();

        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        input = scanner.nextLine(); //

        parser.validateString(input);

        List<BigDecimal> bigDecimalsList;
        bigDecimalsList = parser.parseAndMultiplyPolynomials(parser.parseStringToPolynom(input));

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal element: bigDecimalsList) {
            sum = sum.add(element);

        }

        System.out.println("Hello. Please, enter string you want to calculate.");
        System.out.println("Allowed characters: '0..9' numbers , '.' dot '+' add , '-' subtract, '*' multiply, '/' divide");
        System.out.println("Input = " + input);
        System.out.println(String.format("Result = %.5f",sum));
       //System.out.println(new BigDecimal(2).add(new BigDecimal(1)));




    }
}
