package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Validation validation = new Validation();

        int firstPrimeNumber = 3;
        int secondPrimeNumber = 37;
        String text = "y > 0";
        text=text.toLowerCase(new Locale("en","US"));


        if (validation.isPrimeNumber(firstPrimeNumber) && validation.isPrimeNumber(secondPrimeNumber)) {
            RSAEncryption rsaEncryption = new RSAEncryption(firstPrimeNumber, secondPrimeNumber);
            String chipsetText = rsaEncryption.encryptText(text);

            System.out.println("---------------------------------------------------------------------------");
            rsaEncryption.decryptText(chipsetText);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("------Emirhan Mesajim sanadir---------------------------------------------------------------------");
            rsaEncryption.decryptText("2z\u0099x\u0088z pavz\u0081z ?\u001F ²avvz ÅaÆvx\u001C Da\u0088xpaÆ x²¤a\u001F Da\u0088xpaÆ x²¤a\u0088x \u0088a¤a\u0099 p~Î Å~Îw" +
                    "\u0099~ÆÆz\u0099x \u0088aya\u0099 ¯z \u0099ay~\u0099½ \u008Fa¤x\u0099Æa\u0099pxÎx¤\u001F\u0019Bx\u0099vz xpwz\u0099pzÎx¤  \u0013\u0081Æza\u0099 ¯z  " +
                    "\u0013\u0081\u008Fxypzw O\u008F~\u0081aÎxÎ pÆa\u0088wÆa\u0099xÎva ¯a\u0099& ~ÎÆa\u0099xva zÅÆz\u0088zbxÆx\u0099pxÎx¤\u001F R ¤a²aÎ \u0099aÎv~² Åa\u0099aÅwz" +
                    "\u0099 \u0088z\u0099xÎz ap\u0081xx Å~vÆa\u0099 g~\u0099½Î½\u0099 pxr\u0099zÆzÎ²xp \u0088z\u0099vz");

        }


    }
}
