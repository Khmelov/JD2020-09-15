package by.it.zubovich.jd01_09.old;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;


    Vector(double[] value) {
        this.value = value;

    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    Vector(String strVector) {
        String[] result = strVector.replace("{","").replace("}","").split(",");
        this.value = new double[result.length];
        for (int i = 0; i < result.length; i++) {
            value[i] = Double.parseDouble(result[i].trim());
        }

    }



    @Override
    public String toString() {

        return Arrays.toString(value).replace("[","{").replace("]","}");


    }
}
