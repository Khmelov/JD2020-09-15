package by.it.kolesnikov.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static Map<String, Var> varMap = new HashMap<>();

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }
        return null;
    }


    public  static Var save (String name, Var value){
    varMap.put(name, value);
    return value;
    }


    @Override
    public Var add(Var other) {
        //TODO create exception
        System.out.printf("Operation%s+%s not work\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation%s-%s not work\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation%s*%s not work\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation%s/%s not work\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
