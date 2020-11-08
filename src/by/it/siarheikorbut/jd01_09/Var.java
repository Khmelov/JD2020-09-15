package by.it.siarheikorbut.jd01_09;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09</a>
 */

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            System.err.println("Незвестная переменная " + strVar);
            return null;
        }
    }
}