package com.mishafauzel.calculator.utills.livedata;

import com.mishafauzel.calculator.utills.interfaces.Observer;
import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

//является очень упрощённой версией LiveData из android разработки, не знает ничего о жизненном цикле Observer объекта,
//, не является препятсвием для сборщика мусора(для данного проекта не критично, но опять же всегда важно думать о расширении)))
public abstract class SimpleLiveData<D> {
    protected D data;
    protected HashMap<String,WeakReference<Observer<D>>> observers=new HashMap<>();

    HashMap<MutableSimpleLiveData,Transformation> transformations=new HashMap();
    public void addObserver(@NotNull String observeKey,@NotNull Observer<D> observer)
    {
        observers.put(observeKey,new WeakReference(observer));
        observer.notifyDataChanged(data);
    }
    public D value()
    {
        return data;
    }
    protected void notifyAllObservers(D newData)
    {
        observers.forEach((name,reference)->
        {
            Observer<D> observer;
            if((observer=reference.get())!=null)
                observer.notifyDataChanged(newData);

        });
    }


    public <T>void  addTransformation(MutableSimpleLiveData<T> liveData, Function<D,T> converter)
    {

        transformations.put(liveData,new Transformation(liveData,converter));
    }
    protected void executeTransformations(D data)
    {
        transformations.forEach(((liveData, transformation) ->
                transformation.transform(data)));
    }



}
