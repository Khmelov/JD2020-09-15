package by.it.fedorinhyk.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class CreateVar implements Operation {

    private static Map<String, CreateVar> varMap= new HashMap<>();

    static CreateVar createVar(String strVar) throws CalcException{
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
            CreateVar var=varMap.get(strVar);
            if (Objects.isNull(var)) {
                System.out.println("Unknow variable: " + strVar);
            }
            throw  new CalcException("Невозможно создать:"+strVar);
        }
    }

    public static CreateVar save(String name, CreateVar value){
        varMap.put(name, value);
        return value;
    }

    public static Map <String, CreateVar> getVarMap(){
        return varMap;
    }

    @Override
    public CreateVar add(CreateVar other) throws CalcException {
        throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");
    }

    @Override
    public CreateVar sub(CreateVar other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");
    }

    @Override
    public CreateVar mul(CreateVar other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");
    }

    @Override
    public CreateVar div(CreateVar other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");
    }
}
