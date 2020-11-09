package by.it.zubovich.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();
    public static Map<String, Var> getVarMap() {
        return vars;
    }
    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    static void load() throws CalcException {
        try {

            List<String> lines = Files
                    .lines(Paths.get(GetFileName.getFilename()))
                    .collect(Collectors.toList());
            Parser parser = new Parser();
            for (String line : lines) {
                parser.calc(line);
            }
        } catch (IOException e) {
            throw new CalcException(e);
        }
    }
    static Var createVar(String operandVar) throws CalcException{

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
        throw  new CalcException("Impossible create " + operandVar);
    }

    @Override
    public String toString() {
        return "Abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operation %s + %s impossible\n", this, other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Operation %s - %s impossible\n", this, other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Operation %s * %s impossible\n", this, other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Operation %s / %s impossible\n", this, other);
    }
}
