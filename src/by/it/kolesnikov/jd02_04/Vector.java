package by.it.kolesnikov.jd02_04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    double[] getValue() {
        return value;
    }

    public Vector(double[] value) {

        this.value = Arrays.copyOf(value,value.length);
    }

    public Vector(Vector otherVector) {
        double[] tmp = otherVector.value;
        this.value = Arrays.copyOf(tmp,tmp.length);
    }

    public Vector(String strVector){
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        double[] vec = new double[strVector.trim().split(",").length];
        for (int i = 0; i < strVector.trim().split(",").length; i++) {
            vec[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
        this.value = vec;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            Vector otherVector = (Vector)other;
            double [] result = new double[this.value.length];
            for (int i=0; i<this.value.length; i++){
                result [i] = this.value[i]+otherVector.value[i];
            }
            return new Vector (result);
        }
         else if (other instanceof Scalar) {
            Scalar otherVector = (Scalar)other;
            double [] result = new double[this.value.length];
            for (int i=0; i<this.value.length; i++){
                result [i] = this.value[i]+ otherVector.getValue();
            }
            return new Vector (result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            Vector otherVector = (Vector)other;
            double [] result = new double[this.value.length];
            for (int i=0; i<this.value.length; i++){
                result [i] = this.value[i]-otherVector.value[i];
            }
            return new Vector (result);
        }
        else if (other instanceof Scalar) {
            Scalar otherVector = (Scalar) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] - otherVector.getValue();
            }
            return new Vector(result);
        }
        else return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            Vector otherVector = (Vector)other;
            double sum=0;
            double [] arr = new double [this.value.length];
            for (int i=0; i<this.value.length; i++){
                arr [i] = this.value[i]*otherVector.value[i];
                sum=sum+arr[i];
            }
            return new Scalar(sum);
        }
        else if (other instanceof Scalar) {
            Scalar otherVector = (Scalar)other;
            double [] result= new double [this.value.length];
            for (int i=0; i<this.value.length; i++){
                result [i] = this.value[i]*otherVector.getValue();
            }
            return new Vector(result);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherVector = (Scalar)other;
            double [] result= new double [this.value.length];
            for (int i=0; i<this.value.length; i++){
                result [i] = this.value[i]/otherVector.getValue();
            }
            return new Vector(result);
        }
        else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter="";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}
