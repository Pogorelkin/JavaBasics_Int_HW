package com.epam.calculator;

import java.util.ArrayList;

public class ParserImpl implements  CustomParser {
    @Override
    public void calculateAndPrint(String s) {

    }

    @Override
    public void parseString(String string) //ArrayList<String>
    {
        ArrayList<String> parsedList = new ArrayList<>();
        int multiplier = 0;
        char plus = (char) '+';
        char minus = (char) '-';
        for (char character: string.toCharArray()) {
             switch (character)
            case '+': ; // mult = 1 continue
            case '-': ; //mult = -1 continue
            default: //add char
        }

        //return parsedList;
    }
}
