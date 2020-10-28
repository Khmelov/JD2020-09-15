package by.it.siarheikorbut.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08 ( B )</a>
 */

//Создание дочернего от класса Var класса Vector
public class Vector extends Var {

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
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
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
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
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }
}