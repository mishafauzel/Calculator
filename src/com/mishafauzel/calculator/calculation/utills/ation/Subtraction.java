package com.mishafauzel.calculator.calculation.utills.ation;

import com.mishafauzel.calculator.calculation.SeparatedString;

public class Subtraction implements Action{
    @Override
    public int execute(SeparatedString separatedString) {
        return separatedString.getNumber1Int()-separatedString.getNumber2Int();
    }
}
