package by.it.frolova.testCalc;


public abstract class Var implements Operation {
    private static Lang manager = Lang.INSTANCE;

    @Override
    public Var add(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var sub(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var mul(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var div(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public String toString() {
        return "from abstract";
    }
}
