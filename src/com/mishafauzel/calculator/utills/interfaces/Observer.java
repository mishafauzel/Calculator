package com.mishafauzel.calculator.utills.interfaces;

public interface Observer<V> {
    void notifyDataChanged(V result);
}
