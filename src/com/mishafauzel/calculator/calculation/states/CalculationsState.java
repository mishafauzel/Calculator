package com.mishafauzel.calculator.calculation.states;

public class CalculationsState {
    public enum TypeOfCalculationState{
        CalculateStringWithTwoNumberAndOneAction
    }
    protected String lineRequiringCalculations;
    protected TypeOfCalculationState calculationState;
    protected CalculationsState(String lineRequiringCalculations,TypeOfCalculationState state) {
        this.lineRequiringCalculations = lineRequiringCalculations;
        this.calculationState=state;
    }
    public TypeOfCalculationState getTypeOfCalculationState()
    {
        return calculationState;
    }
    public String getLineRequiringCalculations()
    {
        return lineRequiringCalculations;
    }

    public static CalculationsState createCalculateStringWithTwoNumberAndOneAction(String lineRequiringCalculations)
    {
        return new CalculateStringWithTwoNumberAndOneAction(lineRequiringCalculations);
    }

    @Override
    public String toString() {
        return "CalculationsState{" +
                "calculationState=" + calculationState +
                '}';
    }

    public static class CalculateStringWithTwoNumberAndOneAction extends CalculationsState
    {

        protected CalculateStringWithTwoNumberAndOneAction(String lineRequiringCalculations) {
            super(lineRequiringCalculations, TypeOfCalculationState.CalculateStringWithTwoNumberAndOneAction);

        }
    }
}
