package com.company;

public class RSAEncryption {

    private final int firstPrimeNumber;
    private final int secondPrimeNumber;
    public static int[] publicKey = new int[2];
    public static int privateKey;
    ASCIICodeCharacterValue asciiCodeCharacterValue = new ASCIICodeCharacterValue();
    EncryptionFundamental encryptionFundamental;

    public RSAEncryption(int firstPrimeNumber, int secondPrimeNumber) {

        this.firstPrimeNumber = firstPrimeNumber;
        this.secondPrimeNumber = secondPrimeNumber;
        encryptionFundamental = new EncryptionFundamental(firstPrimeNumber, secondPrimeNumber);

    }


    void calculateFundamentals() {
        encryptionFundamental.prepareAllValues();
        publicKey[0] = encryptionFundamental.getNValue();
        publicKey[1] = encryptionFundamental.getEValue();
        privateKey = encryptionFundamental.getDValue();
        System.out.println("public key : (" + publicKey[0] + "," + publicKey[1] + ")");
        System.out.println("private key : (" + privateKey + ")");


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
        int characterValue = asciiCodeCharacterValue.getValueOfCharacter(character);
        characterValue -= 97;
        int calculation = powWithMod(characterValue, encryptionFundamental.getEValue());
        return asciiCodeCharacterValue.getCharacterOfValue(calculation);

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
        System.out.println(decryptedText);
    }

    char decryptCharacter(char character) {
        int characterValue = asciiCodeCharacterValue.getValueOfCharacter(character);
        characterValue -= 97;
        int calculation = powWithMod(characterValue, encryptionFundamental.getDValue());
        return asciiCodeCharacterValue.getCharacterOfValue(calculation);

    }
}
