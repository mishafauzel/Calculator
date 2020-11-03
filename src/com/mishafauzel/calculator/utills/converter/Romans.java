package com.mishafauzel.calculator.utills.converter;

import java.util.Arrays;
import java.util.List;
// перечисление хранящие римские цифры
public enum Romans {
    C(100),XC(90),L(50),XL(40),X(10),IX(9),
    V(5), IV(4), I(1);


    private final int intRepresentation;

    public int getIntRepresentation() {
        return intRepresentation;
    }

    Romans(int intRepresentation) {

        this.intRepresentation = intRepresentation;
    }



}
