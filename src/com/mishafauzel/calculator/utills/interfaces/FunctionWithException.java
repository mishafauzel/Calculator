package com.mishafauzel.calculator.utills.interfaces;

public interface FunctionWithException<T,R> {
    R apply(T t)throws Exception;

}
