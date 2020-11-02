package by.it.frolova.testCalc;

import by.it.akhmelev.calculator.CalcException;

public interface Operation {

    Var add(Var other) throws CalcException, CalcExceptions;

    Var sub(Var other) throws CalcException, CalcExceptions;

    Var mul(Var other) throws CalcExceptions;

    Var div(Var other) throws CalcExceptions;
}
