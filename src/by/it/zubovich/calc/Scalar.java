package by.it.zubovich.calc;

public class Scalar extends Var {

    private final double value;

//    public double getValue(){
//
//        return value;
//    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {

        this.value = scalar.value;
    }

    Scalar(String strScalar) {

        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString(){

        return Double.toString(value);
    }
}
