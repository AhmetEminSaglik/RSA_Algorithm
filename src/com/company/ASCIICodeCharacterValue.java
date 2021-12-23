package com.company;

public class ASCIICodeCharacterValue {

    public int getValueOfCharacter(char character) {
         return (int) character;
    }
    public char getCharacterOfValue(int characterValue) {

        return (char) (characterValue + 97);
    }

}
