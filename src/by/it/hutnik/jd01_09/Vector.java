package by.it.hutnik.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }
    public Vector(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        str = sb.toString();
        String[] arraysStr = str.split(",");

        this.value = new double[arraysStr.length];
        for (int i = 0; i < arraysStr.length; i++) {
            value[i] = Double.parseDouble(arraysStr[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] += ((Scalar) other).getValue();
            }
            return new Vector(add);
        } else
            if (other instanceof Vector) {
            double[] add=Arrays.copyOf(value,value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] += ((Vector) other).value[i];
            }
            return new Vector(add);
        } else return super.add(other);
    }

        @Override
        public Var sub (Var other){
            if (other instanceof Scalar){
                double[] sub=Arrays.copyOf(value,value.length);
                for (int i = 0; i < sub.length; i++) {
                    sub[i] -= ((Scalar) other).getValue();
                }
                return new Vector(sub);
            } else
                if (other instanceof Vector){
                    double[] sub=Arrays.copyOf(value,value.length);
                    for (int i = 0; i < sub.length; i++) {
                        sub[i] -= ((Vector) other).value[i];
                    }
                    return new Vector(sub);
                }
        return super.sub(other);
        }

        @Override
        public Var mul (Var other){
            if (other instanceof Scalar){
                double[] mul=Arrays.copyOf(value, value.length);
                for (int i = 0; i < mul.length; i++) {
                    mul[i] *= ((Scalar) other).getValue();
                }
                return new Vector(mul);
            } else if (other instanceof Vector) {
                double[] mul=Arrays.copyOf(value,value.length);
                double mult=0;
                for (int i = 0; i < mul.length; i++) {
                    mult += mul[i]* ((Vector) other).value[i];
                }
                return new Scalar(mult);
            }
        return super.mul(other);
        }

        @Override
        public Var div (Var other){
            if (other instanceof Scalar){
                double[] div = new double[value.length];
                for (int i = 0; i < div.length; i++) {
                    div[i] = value[i] / ((Scalar) other).getValue();
                }
                return new Vector(div);
            } else
                if (other instanceof Vector) {
                    return super.div(other);
                } else
        return super.div(other);
        }

        @Override
        public String toString() {
            String str = "{";
            for (int i = 0; i < value.length-1; i++) {
                str+= value[i]+", ";
            }
            str+=value[value.length-1]+"}";
            return str;
        }

}

