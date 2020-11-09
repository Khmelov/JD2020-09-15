package by.it.siarheikorbut.calc;

public class VarCreator {

    static Var createVar(String strVar) throws CalcException {
        Var var;
        if (strVar.matches(Patterns.SCALAR)) {
            var = new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            var = new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            var = new Matrix(strVar);
        } else if (Var.vars.containsKey(strVar)) {
            var = Var.vars.get(strVar);
        } else {
            throw new CalcException(Var.resource.get(Error.UNKNOWN_VARIABLE) + strVar);
        }
        return var;
    }
}