package by.it.siarheikorbut.jd01_08;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08 ( A, B, C )</a>
 */

public abstract class Var implements Operation {
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