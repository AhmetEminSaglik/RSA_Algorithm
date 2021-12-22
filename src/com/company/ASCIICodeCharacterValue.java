package com.company;

import javax.swing.*;

public class ASCIICodeCharacterValue extends CharacterCodeValue {
    @Override
    public int getValueOfCharacter(char character) {

//        JOptionPane.showMessageDialog(null, "character  :" + character + " sayisi : "
//                + ((int) character));
        return (int) character;
    }

    @Override
    public char getCharacterOfValue(int characterValue) {

        return (char) (characterValue + 97);
    }

}
