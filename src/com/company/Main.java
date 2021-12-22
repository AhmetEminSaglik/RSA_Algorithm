package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        String text = "abcdefghijklmnopqrstuvwxyz  Omer Bana yardim ediyor";//"abcdefghijklmnopqrstuvwxyz";

        Validation validation = new Validation();

        int firstPrimeNumber = 3;
        int secondPrimeNumber = 11;
        String text = "Omer Ekmek sorun cozuldu  abcdefghijklmnopqrstuvwxyz ";//"abcdefghijklmnopqrstuvwxyz";
        text = text.toLowerCase(new Locale("en", "US"));
        CharacterCodeValue characterCodeValue = new ASCIICodeCharacterValue();
//        CharacterCodeValue characterCodeValue = new MyAlphabetCode();
//
        if (validation.isPrimeNumber(firstPrimeNumber) && validation.isPrimeNumber(secondPrimeNumber)) {
            RSAEncryption rsaEncryption = new RSAEncryption(firstPrimeNumber, secondPrimeNumber, characterCodeValue);
            String chipsetText = rsaEncryption.encryptText(text);
            System.out.println("---------------------------------------------------------------------------");
            rsaEncryption.decryptText(chipsetText);

        }
        System.out.println("TEXT :" + text);
//        System.out.println(Math.pow(97,5));
//        System.out.println(8.587340257E9%14);
//        System.out.println("2147483647   ::: " + (2147483642 % 14));
//        System.out.println(new ASCIICodeCharacterValue().getValueOfCharacter('z'));
//        System.out.println(new MyAlphabetCode().getValueOfCharacter('z'));

//        System.out.println(Math.pow(4, 11));
//        System.out.println(Math.pow(4, 11) / 14);
//        System.out.println(Math.pow(4, 11) % 14);
        /*
         * ANAHTAR OLUSTURMA
         * 2 tane asal sayi secilecek
         * n = p * q
         *
         * o = (p-1)(q-1)
         *  1 < e < o
         *
         * gizli us hesaplanir  (1 < d < o)
         * d*e ≡ (d*e mod o=1)
         * Genel anahtar (n,e) ve ozel anahtar  (d,d)    p, q, o  degerleri gizli tutulmalidir
         *
         * Sifreleme
         * 1   asal sayi seciyoruz  ,   7,17
         * 2   n= 7 * 17 = 19
         * 3   o = 6 * 16 = 96
         * 4   Toilent fonksiyon sonucu  ile aralarinda  asal olan  ve 1  den buyuk  sayi secilir
         *  1 < e < 96 icin e = 13 secebilirim cunku 96 ile aralarinda  asal
         * 5    gizli anahtar bulunacak  Extended Euclid Algorithm kullanicaz
         * d.e ≡ 1 mod o    olacak sekilde d sayisini bulacaz
         *
         *      de = + 1 k* mod o
         *      e = 13, o = 96 ve n = 119
         *      k = 0 icin  d = (1 + 0 * 96)/13 =   1 / 13
         *      k = 1 icin  d = (1 + 1 * 96)/13 =  97 / 13
         *      k = 2 icin  d = (1 + 2 * 96)/13 = 193 / 13
         *      k = 3 icin  d = (1 + 3 * 96)/13 = 289 / 13
         *      k = 4 icin  d = (1 + 4 * 96)/13 = 385 / 13
         *      k = 5 icin  d = (1 + 5 * 96)/13 = 481 / 13
         *      private key degerimiz n = 119 , d = 37
         *      public key degerimiz  n = 119 , e = 13
         *
         *      SIFRELEME
         *  simdi E ve C harflerini sifrelicez
         *  C ≡ m ^ e (mod n) (1)
         *  E = 45  icin ; C ≡ 45 ^ 13 ( mod 119 ) ≡ 24 (mod 119)
         *  C = 43 icin ;  C ≡ 43 ^ 13 ( mod 119 ) ≡ 8  (mod 119)
         *
         *      SIFRE COZME
         *   M ≡ C ^ d ( mod  n) (1)
         *   24 ^ 13 ( mod 119 )  ≡ 45  ( mod 119 )
         *   8 ^ 13 ( mod 119 )  ≡ 43  ( mod 119 )
         *
         *  Bir kisiden bir kisiye  metin gonderilecek
         * Metin sifrelenmis olarak gonderilecek
         * Metin
         *
         * */

    }
}
