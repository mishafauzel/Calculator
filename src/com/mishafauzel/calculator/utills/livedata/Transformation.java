package com.mishafauzel.calculator.utills.livedata;

import java.util.function.Function;

public class Transformation<from, to> {
    private MutableSimpleLiveData<to> targetLiveData;
    private Function<from,to> converter;

    public Transformation(MutableSimpleLiveData<to> targetLiveData, Function<from, to> converter) {
        this.targetLiveData = targetLiveData;
        this.converter = converter;
    }
    public void transform(from inputData)
    {
        targetLiveData.putData(converter.apply(inputData));
    }
}
