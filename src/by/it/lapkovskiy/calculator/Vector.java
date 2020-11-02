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
        strVector = strVector.replace(" ","");
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
            st+= value[i]+", ";
        }
        st+=value[value.length-1]+"}";
        return st;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getVectorAddScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.VECTOR)){
            return getVectorAddVector((Vector) other);
        }
        else {
            return  super.add(this);
        }
    }

    private Vector getVectorAddVector(Vector other) throws CalcException {
        exceptionLength(other);
        double[] arr = new double[other.value.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value[i] + other.value[i];
        }
        return new Vector(arr);
    }

    private Vector getVectorAddScalar(Scalar other) {
        double[] sum = Arrays.copyOf(value,value.length);
        for (int i = 0; i < sum.length; i++) {
            sum[i] += other.value;
        }
        return new Vector(sum);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getVectorSubScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.VECTOR)){
            return getVectorSubVector((Vector) other);
        }
        else {
            return  super.sub(this);
        }
    }

    private Vector getVectorSubVector(Vector other) throws CalcException {
        exceptionLength(other);
        double[] arr = new double[other.value.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value[i] - other.value[i];
        }
        return new Vector(arr);
    }

    private Vector getVectorSubScalar(Scalar other) {
        double[] sub = Arrays.copyOf(value,value.length);
        for (int i = 0; i < sub.length; i++) {
            sub[i] -= other.value;
        }
        return new Vector(sub);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getVectorMulScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.VECTOR)){
            return getVectorMulVector((Vector) other);
        }
        else {
            return  other.mul(this);
        }
    }

    private Scalar getVectorMulVector(Vector other) throws CalcException {
        exceptionLength(other);
        double arr = 0;
        for (int i = 0; i < value.length; i++) {
            arr += value[i] * other.value[i];
        }
        return new Scalar(arr);
    }

    private void exceptionLength(Vector other) throws CalcException {
        if (other.value.length != value.length)
            throw new CalcException(ConsoleRunner.rasMan.get(Message.length_not_equals));
    }

    private Vector getVectorMulScalar(Scalar other) {
        double[] sub = Arrays.copyOf(value,value.length);
        for (int i = 0; i < sub.length; i++) {
            sub[i] *= other.value;
        }
        return new Vector(sub);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getVectorDivScalar((Scalar) other);
        }
        else {
            return  super.div(this);
        }
    }

    private Vector getVectorDivScalar(Scalar other) {
        double[] sub = Arrays.copyOf(value,value.length);
        for (int i = 0; i < sub.length; i++) {
            sub[i] /= other.value;
        }
        return new Vector(sub);
    }
}
