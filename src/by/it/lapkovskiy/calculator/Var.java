package by.it.lapkovskiy.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Var implements Operation {


    private static Map<String, Var> varMap = new HashMap<>();

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                throw new CalcException(ConsoleRunner.rasMan.get(Message.unknown_variable)+": " + strVar);
            }
            return var;
        }
    }

    public static Var save(String name, Var value) {
        varMap.put(name, value);
        return value;

    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(""+ConsoleRunner.rasMan.get(Message.operation)+" %s + %s "
                +ConsoleRunner.rasMan.get(Message.impossible)+"\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(""+ConsoleRunner.rasMan.get(Message.operation)+" %s - %s " +
                ConsoleRunner.rasMan.get(Message.impossible)+"\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(""+ConsoleRunner.rasMan.get(Message.operation)+" %s * %s " +
                ConsoleRunner.rasMan.get(Message.impossible)+"\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(""+ConsoleRunner.rasMan.get(Message.operation)+" %s / %s " +
                ConsoleRunner.rasMan.get(Message.impossible)+"\n", this, other));
    }

    @Override
    public String toString() {
        return ConsoleRunner.rasMan.get(Message.abstract_var);
    }
}
