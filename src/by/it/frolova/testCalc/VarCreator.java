package by.it.frolova.testCalc;

import java.util.Map;
import java.util.Objects;

public class VarCreator {
    VarCreator(Map<String, Var> varMap){
        this.varMap = varMap;
    }
    private static Lang manager = Lang.INSTANCE;
    private final Map<String, Var> varMap;

    Var createVar(String strVar) throws CalcExceptions {
        Var var;
        if (strVar.matches(Patterns.SCALAR)) {
            var = new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            var = new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            var = new Matrix(strVar);
        } else {
            var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                throw new CalcExceptions(manager.get(Error.ERROR_UNKNOWN) + " " + strVar);
            }
        }
        return var;
    }
}

