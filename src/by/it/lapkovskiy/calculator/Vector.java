package by.it.lapkovskiy.calculator;

import java.util.Arrays;

public class Vector extends Var {
    public double[] value;
    double[] getValue(){
        return  value;
    }
    Vector(double[] value){
        this.value = Arrays.copyOf(value,value.length);
    }
    Vector(Vector vector){
        this.value = Arrays.copyOf(vector.value,vector.value.length);
    }
    Vector(String strVector){
        strVector = strVector.replace("{","");
        strVector = strVector.replace("}","");
        String[] arr = strVector.split(",");
        double[] arrDouble = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrDouble[i] = Double.parseDouble(arr[i]);
        }
        this.value = Arrays.copyOf(arrDouble,arrDouble.length);
    }

    @Override
    public String toString() {
        String st = "{";
        for (int i = 0; i < value.length-1; i++) {
            st+= value[i]+",";
        }
        st+=value[value.length-1]+"}";
        return st;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Scalar) other).value;
            }
            return new Vector(sum);
        }
        else if(other instanceof Vector){
            if(((Vector) other).value.length!=value.length) throw new CalcException(" length not eq");
            double[] arr = new double[((Vector) other).value.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = value[i] + ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        else {
            return  super.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Scalar) other).value;
            }
            return new Vector(sub);
        }
        else if(other instanceof Vector){
            if(((Vector) other).value.length!=value.length) throw new CalcException(" length not eq");
            double[] arr = new double[((Vector) other).value.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = value[i] - ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        else {
            return  super.sub(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] *= ((Scalar) other).value;
            }
            return new Vector(sub);
        }
        else if(other instanceof Vector){
            if(((Vector) other).value.length!=value.length) throw new CalcException(" length not eq");
            double arr = 0;
            for (int i = 0; i < value.length; i++) {
                arr += value[i] * ((Vector) other).value[i];
            }
            return new Scalar(arr);
        }
        else {
            return  other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] /= ((Scalar) other).value;
            }
            return new Vector(sub);

        }
        else {
            return  super.div(this);
        }
    }
}
