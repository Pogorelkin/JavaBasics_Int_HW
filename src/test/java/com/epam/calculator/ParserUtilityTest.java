package com.epam.calculator;

import com.epam.calculator.utility.parser.CustomParser;
import com.epam.calculator.utility.parser.ParserImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ParserUtilityTest {
    Logger logger = LoggerFactory.getLogger(ParserUtilityTest.class);
    String testString;
    CustomParser parser = new ParserImpl();

    @Test
    public void testParseStringToPolynom() {
        testString = "34*5-12*2+4*5";
        List<String> expectedList = Arrays.asList("34*5", "-12*2", "4*5");
        List<String> actualList = new ArrayList<>();

        actualList = parser.parseStringToPolynom(testString);
        Assert.assertEquals(actualList, expectedList);

    }

    @Test
    public void testparseAndMultiplyPolynomials() {
        BigDecimal bd1 = new BigDecimal(6);
        BigDecimal bd2 = new BigDecimal(-24);
        BigDecimal bd3 = new BigDecimal(20);
        BigDecimal[] bdArray = {bd1, bd2, bd3};
        List<BigDecimal> expectedList = Arrays.asList(bdArray);
        List<String> inputList = Arrays.asList("2*3", "-12*2", "10*2");
        List<BigDecimal> actualList = new ArrayList<>();

        actualList = parser.parseAndMultiplyPolynomials(inputList);

        for (int i = 0; i < expectedList.size()-1 ; i++) {
            assertThat(actualList.get(i), Matchers.comparesEqualTo(expectedList.get(i)));
        }
    }

}
