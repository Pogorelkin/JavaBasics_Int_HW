package com.epam.calculator.utility.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal calcByFlag(Character flag, BigDecimal temp, BigDecimal resultNum) {
        switch (flag) {
            case ('n'):
                return temp;


            case ('m'):
                return resultNum.multiply(temp);


            case ('d'):
                return resultNum.divide(temp, 3, RoundingMode.CEILING);

            default:
                return resultNum.multiply(temp);


        }
    }
}
