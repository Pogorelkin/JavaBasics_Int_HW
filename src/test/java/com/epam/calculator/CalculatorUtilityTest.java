package com.epam.calculator;

import com.epam.calculator.utility.services.Calculator;
import com.epam.exceptions.CalculationException;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorUtilityTest {
    Logger logger = LoggerFactory.getLogger(CalculatorUtilityTest.class);
    private char flag;
    BigDecimal number1 = new BigDecimal(21);
    BigDecimal number2 = new BigDecimal(42);
    BigDecimal actual = new BigDecimal(0);
    Calculator calculator = new Calculator();

    @Test
    public void testCalcByFlagMultiplicationBigDecimal_21Mult42In_882Out() {

        flag = 'm';
        BigDecimal expected = new BigDecimal(882);
        try {
            actual = calculator.calcByFlag(flag, number1, number2);
            assertThat(actual, Matchers.comparesEqualTo(expected));
        } catch (CalculationException e) {
            logger.info(e.getMessage());
        }

    }

    @Test
    public void testCalcByFlagDivisionBigDecimal_42Div21In_2Out() {

        flag = 'd';
        BigDecimal expected = new BigDecimal(2);

        try {
            actual = calculator.calcByFlag(flag, number1, number2);
            assertThat(actual, Matchers.comparesEqualTo(expected));
        } catch (CalculationException e) {
            logger.info(e.getMessage());
        }
    }
}
