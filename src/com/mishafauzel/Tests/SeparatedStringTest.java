package com.mishafauzel.Tests;

import com.mishafauzel.calculator.calculation.SeparatedString;
import com.mishafauzel.calculator.calculation.SimpleSeparatedStringPreparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedStringTest {
    int[] firstNumbers={1,2,3,4,5,6,7,8,9,0,10};
    int[] secondNumbers={1,2,3,4,5,6,7,8,9,10};
    String[] actions={"+","-","/","*"};
    SimpleSeparatedStringPreparator.TypeOfString arabicTypeOfString= SimpleSeparatedStringPreparator.TypeOfString.Arabic;
    SimpleSeparatedStringPreparator.TypeOfString romanTypeOfString= SimpleSeparatedStringPreparator.TypeOfString.Roman;

    @Test
    void executeAction() throws Exception{
      for(Integer number1:firstNumbers)
          for (Integer number2:secondNumbers)
          {
              SeparatedString sepStringWithPlus=SeparatedString.getInstance(String.valueOf(number1),String.valueOf(number2),actions[0], arabicTypeOfString);
              SeparatedString sepStringWithMinus=SeparatedString.getInstance(String.valueOf(number1),String.valueOf(number2),actions[1], arabicTypeOfString);
              SeparatedString sepStringWithDivision=SeparatedString.getInstance(String.valueOf(number1),String.valueOf(number2),actions[2], arabicTypeOfString);
              SeparatedString sepStringWithMultiplier=SeparatedString.getInstance(String.valueOf(number1),String.valueOf(number2),actions[3], arabicTypeOfString);
              assertAll(()-> {
                  assertEquals(String.valueOf(number1+number2),sepStringWithPlus.formatResult());
                      },
                      ()->{
                          assertEquals(String.valueOf(number1-number2),sepStringWithMinus.formatResult());
                      },
                      ()->{
                          assertEquals(String.valueOf(number1*number2),sepStringWithMultiplier.formatResult());
                      },
                      ()->{
                          assertEquals(String.valueOf(number1/number2),sepStringWithDivision.formatResult());
                      },()->
                      assertThrows(ArithmeticException.class,
                              ()->
                              {
                                 SeparatedString.getInstance(String.valueOf(number1),"0",actions[2],arabicTypeOfString).formatResult();
                              }
                      ));
          }
    }


}