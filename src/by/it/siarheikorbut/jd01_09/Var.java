package by.it.siarheikorbut.jd01_09;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09 ( A, B, C )</a>
 */

//Создание пустого абстрактного класса.
public abstract class Var implements Operation {

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        System.out.println("Неизвестная переменная " + operand);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + " невозможна!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + " невозможна!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + " невозможна!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + " невозможна!");
        return null;
    }

    @Override
    public String toString() {
        return "Это Var";
    }
}