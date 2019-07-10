package com.epam.calculator.utility.services;

import com.epam.exceptions.CalculationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal calcByFlag(Character flag, BigDecimal temp, BigDecimal resultNum) throws CalculationException {
        switch (flag) {
            case ('n'):
                return temp;

            case ('m'):
                return resultNum.multiply(temp);

            case ('d'): {
                if (temp == BigDecimal.ZERO) {
                    throw new CalculationException("You cannot divide by zero");
                }
                return resultNum.divide(temp, 3, RoundingMode.CEILING);
            }

            default:
                return resultNum.multiply(temp);


        }
    }
}
