package by.it.zubovich.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    static Var createVar(String operandVar){

        if (operandVar.matches(Patterns.SCALAR)){
            return new Scalar(operandVar);
        }
        else if (operandVar.matches(Patterns.VECTOR)){
            return new Vector(operandVar);
        }
        else if (operandVar.matches(Patterns.MATRIX)){
            return new Matrix(operandVar);
        }
        else if (vars.containsKey(operandVar)){
            return vars.get(operandVar);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null;
    }
}
