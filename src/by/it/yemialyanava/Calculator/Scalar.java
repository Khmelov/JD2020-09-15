package by.it.yemialyanava.Calculator;
class Scalar extends Var  {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strValue){
        this.value = Double.parseDouble(strValue);
    }

    public Scalar (Scalar otherScalar){
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum) ;
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar) other).value;
            Scalar result = new Scalar(sub);
            return result;
        } else {
            return other.sub(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            if (otherScalar.value==0){
                throw new CalcException("multiply by 0");
            }
            double mul = this.value * otherScalar.value;
            return new Scalar(mul);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar) other;
            if (otherScalar.value==0){
                throw new CalcException("division by zero");
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
