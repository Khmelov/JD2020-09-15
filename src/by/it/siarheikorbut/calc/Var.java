package by.it.siarheikorbut.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var) throws CalcException {
        vars.put(name, var);
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (operand.matches(Patterns.VARNAME)) {
            return vars.get(operand);
        } else {
            throw new CalcException("Неизвестная переменная");
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + " + other + " невозможна!");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + " невозможна!");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " невозможна!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " невозможна!");
    }
}