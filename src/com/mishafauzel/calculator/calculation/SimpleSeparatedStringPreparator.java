package com.mishafauzel.calculator.calculation;

import static com.mishafauzel.calculator.utills.MessagesConstants.*;
//класс служащий для создания класса SeparatedString
public class SimpleSeparatedStringPreparator {
    public enum TypeOfString{
        Arabic,Roman,
    }
    private String data;
    public TypeOfString typeOfInputString;
    //регулярное выражение, проверяющее есть ли в строке один и только из символов +/-/*//
    private final String actionRegex="[+\\-*/]{1}";
    //регулярное выражение, проверяющее есть ли в строке один или более символов i/v/x
    private final String romanNumberRegex="[ivx]+";
    //регулярное выражение проверяющее есть ли в строке арабские цифры
    private final String arabicNumberRegex="[1-9][0-9]*";

    public static SimpleSeparatedStringPreparator createNewInstance(String data) {
        SimpleSeparatedStringPreparator newInstance=new SimpleSeparatedStringPreparator();
        newInstance.data=data;
        return newInstance;
    }

    public SeparatedString prepareSeparatedString() throws Exception {
        checkString();
        String[] numbers=data.split(actionRegex);
        int actionPos=numbers[0].length();
        String action=data.substring(actionPos,actionPos+1);

        return SeparatedString.getInstance(numbers[0],numbers[1],action,typeOfInputString);
    }


    private void checkString() throws Exception
    {
        data=deleteWhitespaces();
        checkTypeOfInputString();



    }


    // удаляем все " " заменяя их на ""
    private String deleteWhitespaces() {
        return data.replace(" ","");

    }
    //проверяем тип строки при помощи регуляных выражений, кидаем исключение если не соответствует ни одному известному типу
    private void checkTypeOfInputString() throws Exception {
        data=data.toLowerCase();
       // System.out.println(data);
        if(data.matches(romanNumberRegex+actionRegex+romanNumberRegex))
            typeOfInputString= TypeOfString.Roman;
        else if(data.matches(arabicNumberRegex+actionRegex+arabicNumberRegex))
            typeOfInputString= TypeOfString.Arabic;
        else throw new Exception(DATA_CONTAINS_UNACCEPTABLE_SYMBOLS);
    }


}
