package com.epam.calculator.utility.parser;

import com.epam.calculator.enums.FlagMultiplication;
import com.epam.calculator.utility.services.Calculator;
import com.epam.exceptions.CalculationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements CustomParser {


    Logger logger = LoggerFactory.getLogger(ParserImpl.class);
    private final char subtract = '-';
    private final char multiply = '*';
    private final char divide = '/';
    private final char add = '+';

    @Override
    public List<String> parseStringToPolynom(String string)
    {
        List<String> parsedList = new ArrayList<>();
        String productionStr = "";


        for (Character character : string.toCharArray()) {

            switch (character) {
                case (' '):
                    break;
                case (add):
                    parsedList.add(productionStr);
                    productionStr = "";
                    break;

                case (subtract):
                    parsedList.add(productionStr);
                    productionStr = "-";
                    break;

                default:
                    productionStr = productionStr.concat(character.toString());
                    break;
            }
        }
        parsedList.add(productionStr);

        return parsedList;
    }

    @Override
    public List<BigDecimal> parseAndMultiplyPolynomials(List<String> stringArrayList) {
        List<BigDecimal> numberArray = new ArrayList<>();

        BigDecimal temp = BigDecimal.ZERO;
        BigDecimal mult;
        BigDecimal resultBD = BigDecimal.ONE;
        String string = "";
        Character flagMult = FlagMultiplication.NOTHING.getCharacter();
        Calculator calculator = new Calculator();
        for (String str : stringArrayList) {

            mult = BigDecimal.ONE;
            for (Character character : str.toCharArray()) {
                switch (character) {
                    case (subtract):
                        mult = mult.multiply(new BigDecimal(-1));
                        break;

                    case (multiply):
                        temp = new BigDecimal(string);
                        try {
                            resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
                        } catch (CalculationException e) {
                            logger.info(e.getMessage());
                        }
                        flagMult = FlagMultiplication.MULTIPLICATION.getCharacter();
                        string = "";
                        break;

                    case (divide):
                        temp = new BigDecimal(string);
                        try {
                            resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
                        } catch (CalculationException e) {
                            logger.info(e.getMessage());
                        }
                        flagMult = FlagMultiplication.DIVIDE.getCharacter();
                        string = "";
                        break;

                    default:
                        string = string.concat(character.toString());


                        break;
                }
                if (!string.isEmpty()) {
                    temp = BigDecimal.valueOf(Double.parseDouble(string));
                }
            }
            try {
                resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
            } catch (CalculationException e) {
                logger.info(e.getMessage());
            }
            resultBD = resultBD.multiply(mult);
            numberArray.add(resultBD);
            string = "";
            resultBD = BigDecimal.ONE;
        }
        return numberArray;
    }
}
