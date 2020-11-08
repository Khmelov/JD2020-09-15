package by.it.siarheikorbut.jd01_08;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08</a>
 */

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
    public String getYourClass(Var other) {
        return "Scalar";
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value * ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value / ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}