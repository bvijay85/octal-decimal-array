package com.examples;

import com.util.FormatConverter;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class OctalToDecimalArray {

    public static void main(String[] args) throws Exception{
        System.out.println("Covert Octal to Binary & Decimal format\n");
        OctalToDecimalArray octalToDecimalArray = new OctalToDecimalArray();
        //String strNumber = "31646541";
        String strNumber = "2277114742311135167021343424004141432061264036716605455350700124251451433665154621070427111157201067171276700627170465777043334607301704736021762632546715076300657713354152655466766041402716542311111131505761476052650004524216161770521652245433114475436547416173670422136456436313334657533062163564254163664432653550166600433332675642447003252221104064117622317044717471111";
        System.out.println("Decoded Decimal Array:" + Arrays.toString(octalToDecimalArray.decodeOctalNumber(strNumber)));
    }

    public String[] decodeOctalNumber(String numberAsString) throws Exception {
        StringBuilder binaryString = new StringBuilder();
        while(numberAsString.length()>0){
            binaryString.append(FormatConverter.octalToBinary(numberAsString.substring(0,1)));
            numberAsString = numberAsString.substring(1);
            if(numberAsString.length()==1) {
                binaryString.append(FormatConverter.octalToBinary(numberAsString));
                numberAsString = "";
            }
        }
        System.out.println("final Binary String: " + binaryString);
        int length = binaryString.length()/8;
        String[] bytes = FormatConverter.convertToByteFormat(binaryString, length);
        System.out.println("final decimal array: " + Arrays.toString(bytes));
        String[] decimalArrays = Stream.of(bytes).filter(Objects::nonNull).map(s -> Integer.parseInt(s, 2)).map(String::valueOf).toArray(String[]::new);
        System.out.println("final DecimalArray :" + Arrays.toString(decimalArrays));

        return decimalArrays;
    }
}
