package com.epam.calculator.utility.parser;

import com.epam.calculator.enums.FlagMultiplication;
import com.epam.calculator.utility.services.Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements CustomParser {

    private final char subtract = '-';
    private final char multiply = '*';
    private final char divide = '/';
    private final char add = '+';


    @Override
    public List<String> parseStringToPolynom(String string) //ArrayList<String>
    {
        ArrayList<String> parsedList = new ArrayList<>();
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
        ArrayList<BigDecimal> numberArray = new ArrayList<>();

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
                        resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
                        flagMult = FlagMultiplication.MULTIPLICATION.getCharacter();
                        string = "";
                        break;

                    case (divide):
                        temp = new BigDecimal(string);
                        resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
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

            resultBD = calculator.calcByFlag(flagMult, temp, resultBD);
            resultBD = resultBD.multiply(mult);
            numberArray.add(resultBD);
            string = "";
            resultBD = BigDecimal.ONE;
        }


        return numberArray;
    }

    //@Override

}
