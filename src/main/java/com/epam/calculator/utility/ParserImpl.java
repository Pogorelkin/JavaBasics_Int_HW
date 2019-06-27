package com.epam.calculator.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements  CustomParser {


    @Override
    public List<String> parseStringToPolynom(String string) //ArrayList<String>
    {
        ArrayList<String> parsedList = new ArrayList<>();
        int multiplier = 0;
        String productionStr = "";
        final char plus = '+';
        final char minus = '-';

        for (Character character : string.toCharArray()) {
            switch (character) {
                case (plus):
                    parsedList.add(productionStr);
                    multiplier = 1;
                    productionStr = "";
                    break;

                case (minus):
                    parsedList.add(productionStr);
                    multiplier = -1;
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
     public BigDecimal calcByFlag(Character flag, BigDecimal  temp , BigDecimal resultNum  ) {
        switch (flag){
            case ('n'): return temp;


            case ('m'): return resultNum.multiply(temp);


            case ('d'): return resultNum.divide(temp,2, RoundingMode.HALF_UP);

            default:     return resultNum.multiply(temp);


        }
    }



    @Override
    public List<BigDecimal> parseAndMultiplyPolynomials(List<String> stringArrayList) {
        ArrayList<BigDecimal> numberArray = new ArrayList<>();

        BigDecimal temp = BigDecimal.ONE;
        BigDecimal mult = BigDecimal.ONE;
        BigDecimal resultBD = BigDecimal.ONE;
        String string = "";
        Character flagMult = 'n';
        for (String str : stringArrayList) {

            for (Character character : str.toCharArray()) {
                switch (character) {
                    case ('-'): mult = mult.multiply(new BigDecimal(-1));
                        break;
                    case ('*'): temp = BigDecimal.valueOf(Float.parseFloat(string));
                        resultBD = calcByFlag(flagMult,temp ,resultBD);
                        flagMult = 'm';
                        break;

                    case ('/'): temp  = BigDecimal.valueOf(Float.parseFloat(string));
                        resultBD = calcByFlag(flagMult,temp ,resultBD);
                        flagMult = 'd';
                        break;

                    default:
                        string = string.concat(character.toString());
                        break;
                }

                string = "0";

            }

            resultBD = calcByFlag(flagMult, temp, resultBD);
            numberArray.add(resultBD);
        }


        return numberArray;
    }
}
