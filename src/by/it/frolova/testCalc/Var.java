package by.it.frolova.testCalc;


public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format("Operation %s + %s impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format("Operation %s - %s impossible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format("Operation %s * %s impossible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format("Operation %s / %s impossible\n", this, other));
    }

    @Override
    public String toString() {
        return "from abstract";
    }
}
