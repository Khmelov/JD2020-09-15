package by.it.siarheikorbut.jd02_04;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    String printTool(Var var) throws CalcException {
        if (var != null) {
            return var.toString();
        }
        throw new CalcException();
    }
}