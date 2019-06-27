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

        List<BigDecimal> bigDecimalsList;
        bigDecimalsList = parser.parseAndMultiplyPolynomials(parser.parseStringToPolynom(input));

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal element: bigDecimalsList) {
            sum = sum.add(element);

        }

        System.out.println("Input = " + input);
        System.out.println(String.format("Result = %.5f",sum));




    }
}
