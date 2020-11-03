package by.it.fedorinhyk.calc;

class Scalar extends CreateVar {

    private double value;

    public double getValue(){return value;}

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public CreateVar add(CreateVar other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public CreateVar sub(CreateVar other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public CreateVar mul(CreateVar other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.add(this);
    }

    @Override
    public CreateVar div(CreateVar other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value==0) {
                throw new CalcException("Деление на ноль");
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        else return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
