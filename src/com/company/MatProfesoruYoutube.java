package com.company;

public class MatProfesoruYoutube {

    public static void main(String[] args) {

    }


    /*
     * p = 2,  q = 7;
     * n = 14;
     * o = 1 * 6
     *
     * Choose e  {  1 < e < o }   ( o ve n  ile  aralarinda asal sayi olucak)
     *  e = 5
     *  Lock (5,14)
     *
     *  Choose d {  d*e ( mod o ) = 1 }
     *              5*d ( mod o ) = 1
     *          5 10 15 20 25
     *          5 4   3  2  1
     *   ilk basamaktaki 5. kolay diye secmeyip, 6 basamak ilerisindeki  11. adimi aliyor
     *
     *
     *  Simdi ise  mesaji gonderme vakti
     *   Encryption : (5,14)
     *   Text  : B  -> 2
     *   2^5 * ( mod 14 ) = 32 ( mod 14 )
     *                    = 4 ( mod 14)
     *
     * chiphertext = D ;
     * Decryption : (11,14)
     * 4^11 ( mod 14 )  --> 2 bulunur
     *
     *
     *
     *
     *     Public key değerlerimiz n =119 e =13
     *                                13 , 119
     *                                 x ,  119
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */
}
