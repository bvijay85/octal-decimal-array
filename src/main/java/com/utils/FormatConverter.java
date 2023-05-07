package com.util;

import java.util.Arrays;
import java.util.Objects;

public class FormatConverter {
    public static String[] convertToByteFormat(StringBuilder binaryString, int length) {
        String[] decimalArray = new String[length +1];
        int h = 0;
        while(binaryString.length()>0){
            if(binaryString.length()>8){
                decimalArray[h++] = binaryString.substring(0,8);
                binaryString = new StringBuilder(binaryString.substring(8));
            } else {
                decimalArray[h] = prefixString(binaryString.toString());
                break;
            }
        }

        return Arrays.stream(decimalArray).filter(Objects::nonNull).toArray(String[]::new);
    }

    public static String prefixString(String s){
        return "0".repeat(Math.max(0, 7 - s.length() + 1)) +s;
    }

    public static boolean validOctalNumber(String number) {

        String pattern = "^[0-7]+$";
        boolean defaultResult = false;
        if (number.matches(pattern)) {
            defaultResult = true;
        }
        return defaultResult;
    }
    public static String octalToBinary(String octalNumber) throws Exception{

        if(!validOctalNumber(octalNumber)) throw new Exception("Invalid octal number");

        int index = 0;
        String binaryNum = "";
        while (index < octalNumber.length()) {
            char charAt = octalNumber.charAt((int)index);
            switch (charAt) {
                case '0':
                    binaryNum += "000";
                    break;

                case '1':
                    binaryNum += "001";
                    break;

                case '2':
                    binaryNum += "010";
                    break;

                case '3':
                    binaryNum += "011";
                    break;

                case '4':
                    binaryNum += "100";
                    break;

                case '5':
                    binaryNum += "101";
                    break;

                case '6':
                    binaryNum += "110";
                    break;

                case '7':
                    binaryNum += "111";
                    break;
                default:
                    System.out.println( "\nProvide an invalid Octal Digit- " + octalNumber.charAt((int)index));
                    break;
            }
            index++;
        }
        return binaryNum;
    }
}
