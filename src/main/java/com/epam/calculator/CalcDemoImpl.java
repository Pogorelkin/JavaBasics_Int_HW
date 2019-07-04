package com.epam.calculator;

import com.epam.calculator.utility.parser.CustomParser;
import com.epam.calculator.utility.parser.ParserImpl;
import com.epam.calculator.utility.services.Validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalcDemoImpl implements CalcDemo {

    private static final Logger LOGGER = Logger.getLogger(CalcDemoImpl.class.getName());

    @Override
    public void startDemo() {
        CustomParser parser = new ParserImpl();
        Validator validator = new Validator();

        String input;
        Scanner scanner = new Scanner(System.in);
        LOGGER.log(Level.INFO, "Hello, Enter a string ");
        LOGGER.log(Level.INFO, "Allowed characters: '0..9' numbers , '.' dot '+' add , '-' subtract, '*' multiply, '/' divide");


        input = scanner.nextLine(); //

         if (!validator.validateString(input)) {
             LOGGER.log(Level.INFO, "Not valid string, use allowed characters");
             System.exit(-1);
         }

        List<BigDecimal> bigDecimalsList;
        bigDecimalsList = parser.parseAndMultiplyPolynomials(parser.parseStringToPolynom(input));

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal element: bigDecimalsList) {
            sum = sum.add(element);

        }

        LOGGER.log(Level.INFO, String.format("Result = %.5f",sum) );






    }
}
