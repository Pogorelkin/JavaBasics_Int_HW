package com.epam.calculator.utility;

import java.math.BigDecimal;
import java.util.List;

public interface CustomParser {

      List<String> parseStringToPolynom(String string); //ArrayList<String>
    BigDecimal calcByFlag(Character flag, BigDecimal num, BigDecimal  temp);
       List<BigDecimal> parseAndMultiplyPolynomials(List<String> stringList);

       void validateString(String string);
}
