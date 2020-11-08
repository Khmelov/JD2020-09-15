package by.it.zubovich.jd01_08;

public abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s impossible\n", this, other);

        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s impossible\n", this, other);
        return null;
    }

}
