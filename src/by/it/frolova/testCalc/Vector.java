package by.it.frolova.testCalc;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector() {

    }

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        double[] temp = vector.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Vector(String strVector) {
        String[] str = strVector.substring(1, strVector.length() - 1).split(",");
        this.value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i].trim());
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double sum[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += otherScalar.getValue();
            }
            Vector result = new Vector(sum);
            return result;

        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double sum[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                sum[i] += otherVector.value[i];
            }
            Vector result = new Vector(sum);
            return result;
        } else {
            try {
                return super.add(other);
            } catch (CalcExceptions calcExceptions) {
                throw new RuntimeException(calcExceptions);
            }
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double sub[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherScalar.getValue();
            }
            Vector result = new Vector(sub);
            return result;

        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double sub[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= otherVector.value[i];
            }
            Vector result = new Vector(sub);
            return result;
        }
        try {
            return super.add(other); // check
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double mul[] = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= otherScalar.getValue();
            }
            Vector result = new Vector(mul);
            return result;

        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double mul = 0;
            double result = 0;
            for (int i = 0; i < value.length; i++) {
                mul = this.value[i] * otherVector.value[i];
                result += mul;
            }
            return new Scalar(result);
        }
        try {
            return super.mul(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double div[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= otherScalar.getValue();
            }
            Vector result = new Vector(div);
            return result;
        }
        try {
            return super.div(other);
        } catch (CalcExceptions calcExceptions) {
            throw new RuntimeException(calcExceptions);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
