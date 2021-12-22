package com.company;

public class MyAlphabetCode extends CharacterCodeValue{

    @Override
    public int getValueOfCharacter(char character) {
        return MyAlphabet.alphabet.indexOf(character);
    }

    @Override
    public char getCharacterOfValue(int characterValue) {
        return MyAlphabet.alphabet.charAt(characterValue);
    }
}
