package com.company;

public class EncryptionFundamental {

    private int firstPrimeNumber;
    private int secondPrimeNumber;
    private int nValue; //multiples of Prime numbers;
    private int totientValue;
    private int eValue; // public key;
    private int dValue;
    private boolean selecteablePrimeNumberMatrix[];
    CharacterCodeValue characterCodeValue;

    public EncryptionFundamental(int firstPrimeNumber, int secondPrimeNumber, CharacterCodeValue characterCodeValue) {
        this.firstPrimeNumber = firstPrimeNumber;
        this.secondPrimeNumber = secondPrimeNumber;
        this.characterCodeValue = characterCodeValue;
    }

    public void prepareAllValues() {

        calculateNValue();
        calculateTotientValue();
        createSelecteablPrimeNumberMatrix(nValue);
        calculateEValue();
        calculateDValue();
        printPreparedValues();
    }

    void printPreparedValues() {
        System.out.println("totient Value : " + totientValue);
        System.out.println("n Value : " + nValue);
        System.out.println("e Value : " + eValue);
        System.out.println("d Value : " + dValue);
        System.out.println("Hesaplanan Lock : (" + eValue + "," + nValue + ")");
    }

    void calculateNValue() {
        nValue = firstPrimeNumber * secondPrimeNumber;
    }

    void calculateTotientValue() {
        totientValue = (firstPrimeNumber - 1) * (secondPrimeNumber - 1);
    }

    void calculateEValue() {
        for (int i = 2; i < nValue; i++) {
            if (nValue % i == 0 || totientValue % i == 0) {
                if (selecteablePrimeNumberMatrix[i] == true) {
                    for (int j = 1; j * i < nValue; j++) {
                        selecteablePrimeNumberMatrix[i * j] = false;
                    }
                }
            }
        }
        for (int i = 2; i < selecteablePrimeNumberMatrix.length; i++) {
            if (selecteablePrimeNumberMatrix[i] == true) {
                eValue = i;
                break;
            }
        }
    }

    void calculateDValue() {
        int i = 1;
        while (true) {
            if (eValue * i % totientValue == 1 && i != eValue) {
                dValue = i;
                return;
            }
            i++;
        }
    }

    void createSelecteablPrimeNumberMatrix(int value) {
        selecteablePrimeNumberMatrix = new boolean[value];  // 14 ise --> 2 den baslayacagi icin 14-1 diyoruz. boylece [0] index aslinda [2] icin gecerli oluyor
        selecteablePrimeNumberMatrix[0] = false;
        selecteablePrimeNumberMatrix[1] = false;
        for (int i = 2; i < selecteablePrimeNumberMatrix.length; i++)
            selecteablePrimeNumberMatrix[i] = true;
    }

    public int getNValue() {
        return nValue;
    }

    public int getTotientValue() {
        return totientValue;
    }

    public int getEValue() {
        return eValue;
    }

    public int getDValue() {
        return dValue;
    }

    public boolean[] getSelecteablePrimeNumberMatrix() {
        return selecteablePrimeNumberMatrix;
    }
}
