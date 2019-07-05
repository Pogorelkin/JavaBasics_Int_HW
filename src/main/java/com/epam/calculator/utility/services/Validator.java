package com.epam.calculator.utility.services;

public class Validator {
    private boolean checkIfCharacterIsOperation(Character character) {
        boolean flag = false;
        switch (character) {
            case (' '):
            case ('+'):
            case ('-'):
            case ('.'):
            case ('/'):
            case ('*'): {
                flag = true;
                break;
            }
            default:
                break;


        }


        return flag;
    }


    public boolean validateString(String string) {
        boolean flag = false;
        for (Character character : string.toCharArray()) {
                flag = checkIfCharacterIsOperation(character);
                if (!flag) flag = Character.isDigit(character);




        }
        return flag;
    }
}
