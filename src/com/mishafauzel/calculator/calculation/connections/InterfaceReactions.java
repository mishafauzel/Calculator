package com.mishafauzel.calculator.calculation.connections;

import com.mishafauzel.calculator.calculation.states.CalculationViewState;
import com.mishafauzel.calculator.utills.DataState;

public interface InterfaceReactions {

    void reactOnError(DataState dataState);
    void reactOnLoading();
    void reactOnViewStateChange(CalculationViewState viewState);
}
