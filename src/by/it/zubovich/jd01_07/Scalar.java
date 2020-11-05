package by.it.zubovich.jd01_07;

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
