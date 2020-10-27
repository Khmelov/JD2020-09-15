package by.it.fedorinhyk.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {

    private static Map<String, Var> varMap= new HashMap<>();

    static Var createVar(String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else{
            Var var=varMap.get(strVar);
            if (Objects.isNull(var)) {
                System.out.println("Unknow variable: " + strVar);
            }
            throw  new CalcException("Невозможно создать:"+strVar);
        }
    }

    public static Var save(String name, Var value){
        varMap.put(name, value);
        return value;
    }

    public static Map <String, Var> getVarMap(){
        return varMap;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");
    }
}
