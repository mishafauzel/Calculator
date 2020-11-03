package com.mishafauzel.io;

import com.mishafauzel.calculator.calculation.connections.InterfaceCalculatorConnector;
import com.mishafauzel.calculator.calculation.states.CalculationsState;
/* класс обеспечивает связь между контроллером интерфейса и классами ответсвенными за вычисления, наследуется от абстрактного класс Коннектора,
реализация метода defineCalculationState позволяет определить какой State пердаётся в классы ответсвтвенные за вычисления, при добавлении новых  State-ов, необходтмо
добавит switch  в метод defineCalculationState
* */
public class CommandLineCalculatorInterface extends InterfaceCalculatorConnector<CommandLineController> {
    public CommandLineCalculatorInterface(CommandLineController controllerOfInterface) {
        super(controllerOfInterface);
    }

    @Override
    protected CalculationsState defineCalculationStateState(String initialData) {
        return CalculationsState.createCalculateStringWithTwoNumberAndOneAction(initialData);
    }





}
