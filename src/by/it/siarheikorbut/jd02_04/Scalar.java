package by.it.siarheikorbut.jd02_04;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value * ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return other.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double zz = ((Scalar) other).value;
            if (zz == 0) throw new CalcException("деление на ноль.");
            double sub = this.value / ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    protected int getSize() {
        return -1;
    }
}