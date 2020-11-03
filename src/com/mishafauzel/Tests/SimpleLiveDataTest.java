package com.mishafauzel.Tests;

import com.mishafauzel.calculator.utills.interfaces.Observer;
import com.mishafauzel.calculator.utills.livedata.MediatorSimpleLiveData;
import com.mishafauzel.calculator.utills.livedata.MutableSimpleLiveData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLiveDataTest {
    private final String key="keys";

    MutableSimpleLiveData<Integer> main;
    MediatorSimpleLiveData<Integer> medSimpleLD;
    Observer<String>[] stringObservers;
    Observer<Integer>[] integerObservers;
    MediatorSimpleLiveData<String> stringMediatorSimpleLiveData;
    @BeforeEach
    void setUp() {
        main=createMainLiveData();
        medSimpleLD=createMediatorLiveData();
        stringObservers= createStringObservers();
        integerObservers=createIntegersObservers();
        stringMediatorSimpleLiveData = createMediatorStringData();
    }

    @Test
    void putData() {
        main.addObserver(key+-1,medSimpleLD);
        main.addTransformation(stringMediatorSimpleLiveData,(integer -> {
            return String.valueOf(integer);
        }));
        for (int i = 0; i < integerObservers.length; i++) {
            main.addObserver(key+i,integerObservers[i]);
        }
        for (int i = 0; i < stringObservers.length; i++) {
            stringMediatorSimpleLiveData.addObserver(key+i,stringObservers[i]);

        }
        main.putData(1);
    }
    private MutableSimpleLiveData<Integer> createMainLiveData()
    {
        MutableSimpleLiveData<Integer> main=new MutableSimpleLiveData<>();

        return main;
    }

    private MediatorSimpleLiveData<Integer> createMediatorLiveData()
    {
        MediatorSimpleLiveData<Integer> medLiveData=new MediatorSimpleLiveData<>();
        return medLiveData;
    }
    private Observer<String>[] createStringObservers()
    {
        Observer<String>[] observers=new Observer[5];
        for (int i = 0; i < observers.length ; i++) {
            observers[i]=new Observer<String>() {

                @Override
                public void notifyDataChanged(String result) {
                    System.out.println("string observers "+result);
                }
            };
        }
        return observers;
    }
    private Observer<Integer>[] createIntegersObservers()
    {
        Observer<Integer>[] observers= new Observer[5];
        for (int i = 0; i < observers.length ; i++) {
            observers[i]=new Observer<Integer>() {

                @Override
                public void notifyDataChanged(Integer result) {
                    System.out.println("Integer observers "+result);
                }
            };
        }
        return  observers;
    }
    private MediatorSimpleLiveData<String> createMediatorStringData()
    {
        return new MediatorSimpleLiveData();
    }

}