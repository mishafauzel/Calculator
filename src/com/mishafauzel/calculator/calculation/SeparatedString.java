package com.mishafauzel.calculator.calculation;

import com.mishafauzel.calculator.calculation.utills.ation.*;
import com.mishafauzel.calculator.calculation.utills.formateer.*;
import com.mishafauzel.calculator.utills.interfaces.FunctionWithException;

import static com.mishafauzel.calculator.calculation.SimpleSeparatedStringPreparator.*;
import static com.mishafauzel.calculator.utills.MessagesConstants.NUMBER_TOO_BIG;
import static com.mishafauzel.calculator.utills.MessagesConstants.UNCKNOWN_ACTION;
public class SeparatedString {
    private int number1Int;
    private int number2Int;
    private Action action;
    private FunctionWithException<String,Integer> formatInput;
    private FunctionWithException<Integer,String> formatOutput;
    private int result;

    private SeparatedString() {
    }

    public static SeparatedString getInstance(String number1, String number2, String typeOfAction,
                                              TypeOfString typeOfString) throws Exception
    {
        SeparatedString instance=new SeparatedString();

        instance.defineFormateers(typeOfString);
        instance.formatInputData(number1, number2);
        if(instance.number1Int>10||instance.number2Int>10)
            throw new Exception(NUMBER_TOO_BIG);
        instance.defineTypeOfAction(typeOfAction);
        return instance;
    }
    private void executeAction() throws Exception
    {
        result=action.execute(this);
    }
    public String formatResult()throws Exception
    {
        executeAction();
        return formatOutput.apply(result);
    }
    public int getNumber1Int() {
        return number1Int;
    }

    public int getNumber2Int() {
        return number2Int;
    }

    private void defineTypeOfAction(String action) throws Exception
    {
        switch (action)
        {
            case "+":
            {
                this.action=new Addition()::execute;
                break;
            }
            case "-":
            {
                this.action=new Subtraction()::execute;
                break;
            }
            case "/":
            {
                this.action=new Division()::execute;
                break;
            }
            case "*":
            {
                this.action=new Multiplication()::execute;
                break;
            }
            default:throw new Exception(UNCKNOWN_ACTION);

        }
    }
    private void defineFormateers(TypeOfString typeOfString)
    {
        switch (typeOfString){
            case Arabic:
            {
                formatInput=new ArabicInputOuputFormateer()::formatInput;
                formatOutput=new ArabicInputOuputFormateer()::formatOutput;
                break;
            }
            case Roman:
            {
                formatInput=new RomanInputOutputFormateer()::formatInput;
                formatOutput=new RomanInputOutputFormateer()::formatOutput;
                break;
            }
        }
    }
    private void formatInputData(String number1,String number2) throws Exception
    {
        number1Int=formatInput.apply(number1);
        number2Int=formatInput.apply(number2);
    }

}
