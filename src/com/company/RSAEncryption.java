package com.company;

public class RSAEncryption {

    private int firstPrimeNumber;
    private int secondPrimeNumber;
    CharacterCodeValue characterCodeValue;
    EncryptionFundamental encryptionFundamental;

    public RSAEncryption(int firstPrimeNumber, int secondPrimeNumber, CharacterCodeValue characterCodeValue) {

        this.firstPrimeNumber = firstPrimeNumber;
        this.secondPrimeNumber = secondPrimeNumber;
        this.characterCodeValue = characterCodeValue;
        encryptionFundamental = new EncryptionFundamental(firstPrimeNumber, secondPrimeNumber, characterCodeValue);
        calculateFundamentals();

    }


    void calculateFundamentals() {
        encryptionFundamental.prepareAllValues();


    }

    String encryptText(String text) {
        calculateFundamentals();
        StringBuilder chiperText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                chiperText.append(' ');
            } else {
                chiperText.append(encryptCharacter(text.charAt(i)));
            }
        }
        System.out.println("Orjinal Text " + text);
        System.out.println("chiper Text " + chiperText);
        return chiperText.toString();

    }

    char encryptCharacter(char character) {
        System.out.println(" SIFRELEME character : " + character);
        int characterValue = characterCodeValue.getValueOfCharacter(character);
        characterValue -= 97;

        int calculation = powWithMod(characterValue, encryptionFundamental.getEValue());
        System.out.println("--- calculation : " + calculation % encryptionFundamental.getNValue());

//        int calculatedValue = (int) calculation;
        return characterCodeValue.getCharacterOfValue(calculation);

    }

    int powWithMod(int val1, int val2) {
        int result = 1;
        for (int i = 1; i <= val2; i++) {
            result = result * val1;
            result = result % encryptionFundamental.getNValue();
        }
        return result;
    }

    void decryptText(String chipsetText) {

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < chipsetText.length(); i++) {
            if (chipsetText.charAt(i) == ' ') {
                decryptedText.append(' ');
            } else {
                decryptedText.append(decryptCharacter(chipsetText.charAt(i)));
            }
        }
        System.out.println("Sifreli  gelmis hali : " + chipsetText);
        System.out.println("Cozulmus  hali : " + decryptedText);
    }

    char decryptCharacter(char character) {
        int characterValue = characterCodeValue.getValueOfCharacter(character);
        characterValue -= 97;
        int calculation = powWithMod(characterValue, encryptionFundamental.getDValue());
        System.out.println("characterValue : " + characterValue);
        System.out.println("pow : " + powWithMod(characterValue, encryptionFundamental.getDValue()));
        System.out.println(" sayi : " + calculation + " modu :" + (calculation % encryptionFundamental.getNValue()));
        calculation %= encryptionFundamental.getNValue();
//        int calculatedValue = (int) calculation;

        return characterCodeValue.getCharacterOfValue(calculation);

    }
}
