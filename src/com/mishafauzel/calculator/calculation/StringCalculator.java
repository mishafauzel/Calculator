package com.mishafauzel.calculator.calculation;

import com.mishafauzel.calculator.calculation.states.CalculationViewState;
import com.mishafauzel.calculator.calculation.states.CalculationsState;
import com.mishafauzel.calculator.utills.DataState;
import com.mishafauzel.calculator.utills.livedata.MediatorSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.MutableSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.SimpleLiveData;

import com.mishafauzel.calculator.utills.interfaces.Observer;


public class StringCalculator implements Observer<CalculationsState> {
    private String keyForLiveData=this.getClass().getName();

    private SimpleLiveData<CalculationsState> stateOfCalculation=new MutableSimpleLiveData<>();
    private MediatorSimpleLiveData<DataState<String>> dataState=new MediatorSimpleLiveData<>();
    private MutableSimpleLiveData<CalculationViewState> calculationViewState=new MutableSimpleLiveData<>();

    public StringCalculator() {
        stateOfCalculation.addObserver(keyForLiveData+1,this);
       dataState.addTransformation(calculationViewState,(result)->
       {

           CalculationViewState viewState = calculationViewState.value();
           if (viewState == null)
               viewState=new CalculationViewState();
           if (result.data!=null)
               viewState.result=result.data;
               return viewState;
       });
    }

    public MutableSimpleLiveData<CalculationsState> getStateOfCalculation() {
        return (MutableSimpleLiveData<CalculationsState>) stateOfCalculation;
    }
    public SimpleLiveData<CalculationViewState> getViewState() {
        return  calculationViewState;
    }
    public SimpleLiveData<DataState<String>> getDataState() {
        return dataState;
    }





    private void calculateSimpleString(String data)
    {
        dataState.putData(DataState.calculating());
       createSimpleStringCalculator(data);

    }
    private SimpleStringCalculator createSimpleStringCalculator(String data)
    {
        SimpleStringCalculator simpleStringCalculator=new SimpleStringCalculator(data);
        simpleStringCalculator.getDataState().addObserver(keyForLiveData+3,dataState);
       return simpleStringCalculator;
    }









    @Override
    public void notifyDataChanged(CalculationsState result) {
       // System.out.println(result);
        calculationViewState.putData(null);
        if(result!=null)
        {
            switch (result.getTypeOfCalculationState())
            {
                case CalculateStringWithTwoNumberAndOneAction:
                {
                    calculateSimpleString(result.getLineRequiringCalculations());
                }
            }
        }
    }


}
