package by.it.zubovich.calc;

public class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public Scalar(Scalar varScalar) {
        this.value = varScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double sum = this.value + otherScalar.value;
            return new Scalar(sum);
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double sub = this.value - otherScalar.value;
            return new Scalar(sub);
        } else return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double mul = this.value * otherScalar.value;
            return new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) {
                throw new CalcException("Division on zero ");
            }
            Scalar otherScalar = (Scalar) other;
            double div = this.value / otherScalar.value;
            return new Scalar(div);
        } else return super.div(other);
    }
}
