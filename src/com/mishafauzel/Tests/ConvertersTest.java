package com.mishafauzel.Tests;

import com.mishafauzel.calculator.utills.converter.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertersTest {
     NumberConverter converter;

    @BeforeEach
    void setUp() {
        converter=NumberConverter.getInstance();
    }

    @Test
    void romanToArabic() throws Exception {
        String[] romanNumbers={"I","II","III","IV","V","VI","VII","VIII","IX","X","XXX","XIX"};
        int[] expectedValue={1,2,3,4,5,6,7,8,9,10,30,19};



            for (int i=0;i<expectedValue.length;i++)
                assertEquals(expectedValue[i], converter.romanToArabic(romanNumbers[i]));

    }

    @Test
    void arabicToRoman() throws Exception {
        String[] expectedValue={"I","II","III","IV","V","VI","VII","VIII","IX","X","XXX","XIX","C","LXXXI","XC"};
        int[] arabicNumber={1,2,3,4,5,6,7,8,9,10,30,19,100,81,90};
        for (int i=0;i<expectedValue.length;i++)
            assertEquals(expectedValue[i], converter.arabicToRoman(arabicNumber[i]));
    }
}