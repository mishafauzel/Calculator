package com.mishafauzel.calculator.calculation.utills.formateer;

import com.mishafauzel.calculator.utills.converter.NumberConverter;

public class RomanInputOutputFormateer implements InputOutputFormateer {
    private NumberConverter converter= NumberConverter.getInstance();
    @Override
    public int formatInput(String input) throws Exception{
        return converter.romanToArabic(input);
    }
    @Override
    public String formatOutput(int input)throws Exception {
        return converter.arabicToRoman(input);
    }
}
