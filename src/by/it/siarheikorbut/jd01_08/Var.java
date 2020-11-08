package by.it.siarheikorbut.jd01_08;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08</a>
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
    public String getYourClass(Var other) {
        return "Var";
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }
}