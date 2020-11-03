package com.mishafauzel.calculator.calculation.utills.formateer;
//интерфейс создан для случая увеличения колличества типов цифр(ну мало ли может мы захотим использовать что то помимо арабских и римских цифр)
public interface InputOutputFormateer {
    int formatInput(String input) throws Exception;
    String formatOutput(int input) throws Exception ;
}
