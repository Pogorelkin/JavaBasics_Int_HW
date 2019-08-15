package com.epam.calculator.enums;

public enum Operations {
     ADD('+'),
    SUBTRACT('-'),
    DIVIDE('/'),
    MULTIPLY('*');

    private char aChar;

    Operations(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }
}
