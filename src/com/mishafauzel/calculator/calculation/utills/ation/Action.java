package com.mishafauzel.calculator.calculation.utills.ation;

import com.mishafauzel.calculator.calculation.SeparatedString;
/*создан на случай если когда-нибудь придётся добавлять действия, чтобы не перерабатывать множество switch-ей
крепко привязан к классу Separated чтобы сохранять гибкость для использования в других проектах нецелесообразно

* */
public interface Action {
    int execute(SeparatedString separatedString) throws Exception;
}
