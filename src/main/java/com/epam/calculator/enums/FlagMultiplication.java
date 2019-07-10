package com.epam.calculator.enums;

public enum FlagMultiplication {
    MULTIPLICATION('m'),
    DIVIDE('d'),
    NOTHING('n');

    private Character character;

    FlagMultiplication(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }
}
