package com.epam.calculator;

import com.epam.calculator.utility.parser.CustomParser;
import com.epam.calculator.utility.parser.ParserImpl;
import com.epam.calculator.utility.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class CalcDemoImpl implements CalcDemo {

    private Logger logger = LoggerFactory.getLogger(CalcDemoImpl.class);

    @Override
    public void startDemo() {
        CustomParser parser = new ParserImpl();
        Validator validator = new Validator();
        String input;
        Scanner scanner = new Scanner(System.in);

        logger.info("Hello, Enter a string ");
        logger.info("Allowed characters: '0..9' numbers , '.' dot '+' add , '-' subtract, '*' multiply, '/' divide");

        input = scanner.nextLine(); //

        if (!validator.validateString(input)) {
            logger.info("Not valid string, use allowed characters");
            System.exit(-1);
        }

        List<BigDecimal> bigDecimalsList;
        bigDecimalsList = parser.parseAndMultiplyPolynomials(parser.parseStringToPolynom(input));

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal element : bigDecimalsList) {
            sum = sum.add(element);

        }

        logger.info(String.format("Result = %.5f", sum));
    }
}
