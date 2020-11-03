package com.mishafauzel.calculator.calculation;

import com.mishafauzel.calculator.utills.DataState;
import com.mishafauzel.calculator.utills.livedata.MutableSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.SimpleLiveData;

public class SimpleStringCalculator {
    private MutableSimpleLiveData<DataState<String>> dataState=new MutableSimpleLiveData<>();
    String dataCalculation;
    SimpleSeparatedStringPreparator stringPreparator;
    public SimpleStringCalculator(String data) {
        //System.out.println("simple string calc "+data);
        dataCalculation=data;
        stringPreparator= SimpleSeparatedStringPreparator.createNewInstance(data);
        initCalculation();
    }

    private void initCalculation() {
        SeparatedString sepString=null;
        try {

            sepString=stringPreparator.prepareSeparatedString();
           // System.out.println(sepString.formatResult());
            dataState.putData(DataState.data(sepString.formatResult()));
        }
        catch (Exception ex)
        {
            //System.out.println(ex.getMessage());
            dataState.putData(DataState.error(ex.getLocalizedMessage()));
            return;
        }

        //System.out.println(sepString.formatResult());



    }

    public SimpleLiveData<DataState<String>> getDataState() {
        return dataState;
    }
}
