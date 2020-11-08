package by.it.siarheikorbut.calc;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    String printToLog(Var var) throws CalcException {
        if (var != null) {
            return var.toString();
        }
        throw new CalcException();
    }
}