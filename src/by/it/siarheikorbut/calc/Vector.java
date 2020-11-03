package by.it.siarheikorbut.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        double[] line = new double[strVector.trim().split(",\\s*").length];
        for (int i = 0; i < line.length; i++) {
            line[i] = Double.parseDouble(strVector.trim().split(",\\s*")[i]);
        }
        this.value = line;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i == value.length - 1) {
                line.append(value[i]).append("}");
                continue;
            }
            line.append(value[i]).append(", ");
        }
        return line.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {

            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    private int getSize() {
        return value.length;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            double[] result = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Vector) other).value[i];
                sum += result[i];
            }
            return new Scalar(sum);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            throw new CalcException("Операция деления  " + other + " на " + Arrays.toString(value) + " невозможна!");
        }
        return super.div(other);
    }
}