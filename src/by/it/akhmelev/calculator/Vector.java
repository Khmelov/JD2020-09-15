package by.it.akhmelev.calculator;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

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
        value=new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            value[i]=Double.parseDouble(parts[i]);
        }
        //...........
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherScalar.getValue();
            }
            Vector result = new Vector(sum);
            return result;
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sum = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherVector.value[i];
            }
            Vector result = new Vector(sum);
            return result;
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
