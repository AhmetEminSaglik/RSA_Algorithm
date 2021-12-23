package com.company;

public class EncryptionFundamental {

    private int firstPrimeNumber;
    private int secondPrimeNumber;
    private int nValue; //multiples of Prime numbers;
    private int totientValue;
    private int eValue; // public key;
    private int dValue;
    private int lClear = 0;
    private int lChipher = 0;
    private boolean selecteablePrimeNumberMatrix[];
    ASCIICodeCharacterValue asciiCodeCharacterValue = new ASCIICodeCharacterValue();

    public EncryptionFundamental(int firstPrimeNumber, int secondPrimeNumber) {
        this.firstPrimeNumber = firstPrimeNumber;
        this.secondPrimeNumber = secondPrimeNumber;
    }

    public void prepareAllValues() {

        calculateNValue();
        calculateLChiper();
        calculateTotientValue();
        createSelecteablPrimeNumberMatrix(totientValue);
        calculateEValue();
        calculateDValue();
        calculateLClear();

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

    void calculateLChiper() {
        lChipher = nValue;
    }

    void calculateTotientValue() {
        totientValue = (firstPrimeNumber - 1) * (secondPrimeNumber - 1);
    }

    void calculateEValue() {
        for (int i = 2; i < totientValue; i++) {
            if (/*nValue % i == 0 ||*/ totientValue % i == 0) {
                if (selecteablePrimeNumberMatrix[i] == true) {
                    for (int j = 1; j * i < totientValue; j++) {
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

    void calculateDValue() {  //1 < d < toteient olmali
        int i = 1;
        while (true) {
            if (eValue * i % totientValue == 1 /*&& i != eValue*/) { // internetteki matematik profosoru ayni geldidgi icin bir sonraki adima oteliyordu
                dValue = i;
                return;
            }
            i++;
        }
    }

    void calculateLClear() {
        int step = 10;
//        System.out.println("Islem oncesi l value " +lClear);
        while (true) {
            if (nValue / step > 0) {
                lClear++;
                step *= 10;
//                System.out.println(" islemler : "+(nValue/step));
            } else {
                break;
            }
        }
        System.out.println("n Sayisi " + getNValue() + " Hesaplanan L basamak degeri " + lClear);
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

    public int getlClear() {
        return lClear;
    }

    public int getlChipher() {
        return lChipher;
    }

    public boolean[] getSelecteablePrimeNumberMatrix() {
        return selecteablePrimeNumberMatrix;
    }
}
