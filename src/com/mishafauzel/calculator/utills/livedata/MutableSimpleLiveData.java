package com.mishafauzel.calculator.utills.livedata;

import com.mishafauzel.calculator.utills.livedata.SimpleLiveData;
import com.mishafauzel.calculator.utills.interfaces.Observer;

import java.util.ArrayList;
import java.util.Arrays;
// расширенные класс SimpleLiveData, который позволяет редактировать содержащиеся данные
public class MutableSimpleLiveData<D> extends SimpleLiveData<D> {

    public SimpleLiveData getAsImmutableLiveData()
    {
        return this;
    }

    public void putData(D data) {
        this.data = data;
       notifyAllObservers(data);

       executeTransformations(data);
    }


}
