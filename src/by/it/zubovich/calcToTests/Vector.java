package by.it.zubovich.calcToTests;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        double[] newValue = vector.value;
        this.value = Arrays.copyOf(newValue, newValue.length);

    }

    public Vector(String strVector) {
        String[] result = strVector
                .replace("{", "")
                .replace("}", "")
                .split(",");
        this.value = new double[result.length];
        for (int i = 0; i < result.length; i++) {
            value[i] = Double.parseDouble(result[i].trim());
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace("[", "{")
                .replace("]", "}");
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sumScalar = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                sumScalar[i] += otherScalar.getValue();
            }
            return new Vector(sumScalar);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] sumVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sumVector.length; i++) {
                sumVector[i] += otherVector.value[i];
            }
            return new Vector(sumVector);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] subScalar = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                subScalar[i] += -otherScalar.getValue();
            }
            return new Vector(subScalar);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] subVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < subVector.length; i++) {
                subVector[i] += -otherVector.value[i];
            }
            return new Vector(subVector);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] mulScalar = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < mulScalar.length; i++) {
                mulScalar[i] *= otherScalar.getValue();
            }
            return new Vector(mulScalar);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[] mulVector = Arrays.copyOf(this.value, this.value.length);
            double sum = 0;
            for (int i = 0; i < mulVector.length; i++) {
                mulVector[i] *= otherVector.value[i];
                sum += mulVector[i];
            }
            return new Scalar(sum);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] divScalar = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < divScalar.length; i++) {
                divScalar[i] /= otherScalar.getValue();
            }
            return new Vector(divScalar);
        } else return super.div(other);
    }
}
