package com.mishafauzel.calculator.calculation.utills.formateer;

public class ArabicInputOuputFormateer implements InputOutputFormateer {
    @Override
    public int formatInput(String input) {
        return Integer.valueOf(input);
    }
    @Override
    public String formatOutput(int input) {
        return String.valueOf(input);
    }



}
