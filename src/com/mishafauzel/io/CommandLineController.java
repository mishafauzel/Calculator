package com.mishafauzel.io;

import com.mishafauzel.calculator.calculation.connections.InterfaceCalculatorConnector;
import com.mishafauzel.calculator.calculation.connections.InterfaceReactions;
import com.mishafauzel.calculator.calculation.states.CalculationViewState;
import com.mishafauzel.calculator.utills.DataState;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.mishafauzel.calculator.utills.MessagesConstants.*;


// класс ответственный за работу с командной строкой, фактически является самы долгоживущим классом потому что существует все время работы программы
public class CommandLineController implements  InterfaceReactions {

    private InterfaceCalculatorConnector calculatorInterface=new CommandLineCalculatorInterface(this);

    public CommandLineController() {

    }


    public void showHelloString()
    {
        System.out.println(HELLO_STRING);
    }
    public void readInputString() {
        String inputString="";
        try
        {
            while (inputString.equalsIgnoreCase("")) {
                showMessages(PLEASE_ENTER_STRING);

                inputString = new BufferedReader(new InputStreamReader(System.in)).readLine();



            }
            }
        catch (IOException exception)
        {
            showMessages(ERROR+exception.getMessage());
            readInputString();
        }
        if(inputString.equalsIgnoreCase("q"))
        {
            showMessages(BYE);
            return;
        }
        else
        {

        calculatorInterface.makeCalculations(inputString);
        }



    }
    public void showMessages(String resultString)
    {
        System.out.println(resultString);
    }
    public void showMessageAndWaitEnter()
    {
        System.out.println(PRESS_ENTER_TO_EXIT);
        try {
            System.in.read();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
       // System.out.println("exit");
        System.exit(0);
    }





    @Override
    public void reactOnError(DataState dataState) {
        showMessages(ERROR+dataState.errorMessage);
        showMessageAndWaitEnter();

    }

    @Override
    public void reactOnLoading() {
        //showMessages("Считаем!!!");
    }

    @Override
    public void reactOnViewStateChange(CalculationViewState viewState) {
        if(viewState!=null)
            if (viewState.result!=null) {
                showMessages(viewState.result);
                showMessageAndWaitEnter();

            }
    }
}
