package by.it.yemialyanava.calcul;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector other) {
        double[] tmp = other.value;
        this.value = Arrays.copyOf(tmp, tmp.length);
    }

    Vector(String strValue) {
        String[] parts = strValue
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            value[i] = Double.parseDouble(parts[i]);
        }
        this.value = value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.VECTORSLENGTH));
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }else {
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ADD_VECTOR_AND_MATRIX));
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.VECTORSLENGTH));
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.SUB_MATRIX_FROM_VECTOR));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.ER_MUL_BY_ZERO));
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( ((Vector)other).value.length != this.value.length){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.VECTORSLENGTH));
            }
            double[] result = Arrays.copyOf(value, value.length);
            double sumResult = 0;
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Vector) other).value[i];
                sumResult += result[i];
            }
            return new Scalar(sumResult);
        } else {
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.MUL_VECTOR_BY_MATRIX));
        }
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                throw new CalcException(ConsoleRunner.manager.get(MessagesNames.DIVISION_BY_ZERO));
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else {
            throw new CalcException(ConsoleRunner.manager.get(MessagesNames.DIVISION_VECTOR_BY_VECTOR_OR_VECTOR_BY_MATRIX));
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ",";
        }
        out.append("}");
        return out.toString();
    }
}
