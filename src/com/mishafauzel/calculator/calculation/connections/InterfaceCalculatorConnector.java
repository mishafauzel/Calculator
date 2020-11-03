package com.mishafauzel.calculator.calculation.connections;

import com.mishafauzel.calculator.calculation.StringCalculator;
import com.mishafauzel.calculator.calculation.states.CalculationViewState;
import com.mishafauzel.calculator.calculation.states.CalculationsState;
import com.mishafauzel.calculator.utills.DataState;
import com.mishafauzel.calculator.utills.livedata.MediatorSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.MutableSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.SimpleLiveData;


public abstract class InterfaceCalculatorConnector<V extends InterfaceReactions> {
    private V controllerOfInterface;
    private String keyForObservers= this.getClass().getName();
    private StringCalculator instanceOfStringCalculator;
    private CalculationsState state;

    public InterfaceCalculatorConnector(V controllerOfInterface) {
        this.controllerOfInterface = controllerOfInterface;
        prepareInstance();
    }

    private final void prepareInstance()
    {
        createInstanceOfStringCalculator();
    }

    public final void makeCalculations(String data)
    {
        state=defineCalculationStateState(data);
       // System.out.println("in interface "+state);
        instanceOfStringCalculator.getStateOfCalculation().putData(state);
    }


    private final void createInstanceOfStringCalculator()
    {
         instanceOfStringCalculator=new StringCalculator();

        SimpleLiveData<DataState<String>> dataState=instanceOfStringCalculator.getDataState();
        SimpleLiveData<CalculationViewState> viewStateOfCalculator=instanceOfStringCalculator.getViewState();
        dataState.addObserver(keyForObservers+1,(value)->
        {
            reactOnDataStateChange(value);
        });
        viewStateOfCalculator.addObserver(keyForObservers+2,(value)->
        {
            reactOnViewStateChange(value);
        });
    }
    private final void reactOnDataStateChange(DataState<String> dataState)
    {
        if(dataState!=null) {
            if (dataState.isLoading) {
                controllerOfInterface.reactOnLoading();
                return;
            }
            if (dataState.errorMessage != null) {
                controllerOfInterface.reactOnError(dataState);
                return;
            }
        }

    }
    private final void reactOnViewStateChange(CalculationViewState viewState)
    {
        controllerOfInterface.reactOnViewStateChange(viewState);
    }
    protected abstract CalculationsState defineCalculationStateState(String initialData);


}
