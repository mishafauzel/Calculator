package com.mishafauzel.calculator.utills.converter;

import java.util.Map;
import java.util.TreeMap;

import static com.mishafauzel.calculator.utills.MessagesConstants.ROMANS_DIDNT_HAVE_NUMBER_LESS_THEN_ONE;

// класс выполняющий преобразование из римских в арабские цифры и обратно
public class NumberConverter {
    /* этот класс является синглтоном, так как нет необходимости создавать множество объектов
         данного класса, двойной проверки и синхронизации в getInstance() нет, так как этот метод
         будет использоваться лишь в одном потоке
        */
    private NumberConverter() {
    }


    public static NumberConverter instance;
    public static NumberConverter getInstance()
    {
        if(instance==null)
            instance=new NumberConverter();
        return instance;
    }
    private static TreeMap<Integer,String> arabicRomanTreeMap=new TreeMap<>();
    private static Romans[] romansNumbers;
    static
    {
        arabicRomanTreeMap.put(1,"I");
        arabicRomanTreeMap.put(4,"IV");
        arabicRomanTreeMap.put(5,"V");
        arabicRomanTreeMap.put(9,"IX");
        arabicRomanTreeMap.put(10,"X");
        arabicRomanTreeMap.put(40,"XL");
        arabicRomanTreeMap.put(50,"L");
        arabicRomanTreeMap.put(90,"XC");
        arabicRomanTreeMap.put(100,"C");
        romansNumbers=Romans.values();
    }
    //римские в арабские
    public int romanToArabic(String roman) throws Exception
    {
        String romanNumeral = roman.toUpperCase();
        int result = 0;

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romansNumbers.length)) {
            Romans symbol = romansNumbers[i];
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getIntRepresentation();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(roman + " cannot be converted to a Roman Numeral");
        }

        return result;

    }
    //арабские в римсее
    public String arabicToRoman(int value)throws Exception

    {
        if(value<=0)
        {

            throw new Exception(ROMANS_DIDNT_HAVE_NUMBER_LESS_THEN_ONE);
        }

        StringBuilder sb=new StringBuilder();
        //System.out.println(value);
        while (value!=0) {
            Map.Entry<Integer, String> entry = arabicRomanTreeMap.floorEntry(value);
            value=value-entry.getKey();
            sb.append(entry.getValue());
        }
        //System.out.println(sb.toString());
        return sb.toString();


    }
}
