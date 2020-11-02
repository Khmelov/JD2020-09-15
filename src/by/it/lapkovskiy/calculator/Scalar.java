package by.it.lapkovskiy.calculator;


public class Scalar extends Var {
    public double value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    Scalar(double value){
        this.value = Double.valueOf(value);
    }
    Scalar(Scalar scalar){
        value = Double.valueOf(scalar.value);
    }
    Scalar(String strScalar){
        value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getAddScalar((Scalar) other);
        }
        else {
            return  other.add(this);
        }
    }

    private Scalar getAddScalar(Scalar other) {
        double sum = this.value+ other.value;
        return new Scalar(sum);
    }

    @Override
    public Var sub(Var other) throws  CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getSubScalar((Scalar) other);
        }
        else {
            return  new Scalar(-1).mul(other).add(this);
        }
    }

    private Scalar getSubScalar(Scalar other) {
        double sub = this.value- other.value;
        return new Scalar(sub);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getMulScalar((Scalar) other);
        }
        else {
            return  other.mul(this);
        }
    }

    private Scalar getMulScalar(Scalar other) {
        double mul = this.value* other.value;
        return new Scalar(mul);
    }

    @Override
    public Var div(Var other) throws CalcException {

        if (other.toString().matches(Patterns.SCALAR)){
            return geDivScalar((Scalar) other);
        }
        else
            return super.div(other);
    }

    private Scalar geDivScalar(Scalar other) throws CalcException {
        exceptionNull(other);
        return new Scalar(this.value / other.value);
    }

    private void exceptionNull(Scalar other) throws CalcException {
        if (other.value==0){
            throw new CalcException(ConsoleRunner.rasMan.get(Message.division_by_zero));
        }
    }

}
