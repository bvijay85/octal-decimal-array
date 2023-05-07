package com.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class OctalToDecimalArrayTest {

    private OctalToDecimalArray octalToDecimalArray;
    private final String VALID_OCTAL_NUM = "31646541";

    @BeforeEach
    public void setUp(){
        System.out.println("Setup method invoked");
        this.octalToDecimalArray = new OctalToDecimalArray();;
    }

    @Test
    public void testDecodeOctalNumberWithValidInput() throws Exception{
        String[] decimalArray  = this.octalToDecimalArray.decodeOctalNumber(VALID_OCTAL_NUM);
        assertThat(decimalArray, is(notNullValue()));
    }

    @Test
    public void testDecodeOctalNumberWithValidNumberAndExpectDecimals() throws Exception{
        String[] decimalArray  = this.octalToDecimalArray.decodeOctalNumber(VALID_OCTAL_NUM);
        assertThat(decimalArray, is(notNullValue()));
        assertTrue(Arrays.asList(decimalArray).contains("103"));
        assertTrue(Arrays.asList(decimalArray).contains("77"));
        assertTrue(Arrays.asList(decimalArray).contains("97"));
    }

    @Test
    public void testDecodeOctalNumberWithValidNumberAndExpectValidDecimals() throws Exception{
        String validOctal = "2277114742311135167021343424004141432061264036716605455350700124251451433665154621070427111157201067171276700627170465777043334607301704736021762632546715076300657713354152655466766041402716542311111131505761476052650004524216161770521652245433114475436547416173670422136456436313334657533062163564254163664432653550166600433332675642447003252221104064117622317044717471111";
        String[] decimalArray  = this.octalToDecimalArray.decodeOctalNumber(validOctal);
        assertThat(decimalArray, is(notNullValue()));
        assertTrue(Arrays.asList(decimalArray).contains("242"));
        assertTrue(Arrays.asList(decimalArray).contains("103"));
        assertTrue(Arrays.asList(decimalArray).contains("137"));
    }

    @Test
    public void testDecodeOctalNumberAndThrowExceptionForInvalidOctalNumber() throws Exception{
        String invalidOctalNumber = "31646549";
        assertThrows(Exception.class, () -> {
             this.octalToDecimalArray.decodeOctalNumber(invalidOctalNumber);
        });
    }

    @Test
    public void testDecodeOctalNumberAndThrowExceptionForAStringInOctalNumber() throws Exception{
        String invalidOctalNumber = "31G646541A";
        assertThrows(Exception.class, () -> {
            this.octalToDecimalArray.decodeOctalNumber(invalidOctalNumber);
        });
    }
}

