package com.mishafauzel.calculator.utills.livedata;

import com.mishafauzel.calculator.utills.interfaces.Observer;
// расширенные класс MutableSimpleLiveData, реализующий интерфейс Observer, может быть передан в качестве подписчика другим LiveData
public class MediatorSimpleLiveData<D> extends MutableSimpleLiveData<D> implements Observer<D> {
    @Override
    public void notifyDataChanged(D result) {
        super.putData(result);
    }
}
