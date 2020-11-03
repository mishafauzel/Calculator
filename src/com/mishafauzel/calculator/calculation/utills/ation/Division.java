package com.mishafauzel.calculator.calculation.utills.ation;

import com.mishafauzel.calculator.calculation.SeparatedString;

public class Division implements Action {
    @Override
    public int execute(SeparatedString separatedString) throws Exception {

        return  separatedString.getNumber1Int()/separatedString.getNumber2Int();
    }
}
