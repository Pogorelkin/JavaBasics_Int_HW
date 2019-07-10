package com.epam.calculator.utility.parser;

import java.math.BigDecimal;
import java.util.List;

public interface CustomParser {

    List<String> parseStringToPolynom(String string);

    List<BigDecimal> parseAndMultiplyPolynomials(List<String> stringList);


}
