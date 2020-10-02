package by.it.fedorinhyk.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double [][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix (Matrix matrix){
        double[][] mat = matrix.value;
        this.value = Arrays.copyOf(mat, mat.length);
    }

    Matrix (String strMatrix){
    }

    @Override
    public String toString() {
        StringBuilder sbv=new StringBuilder("{");
        String delimiter="";
        for (double[] element : value){
            sbv.append(delimiter).append(element);
            delimiter=", ";
            for (double elements : element) {
                sbv.append("{").append(delimiter).append(elements).append("}");
                delimiter=", ";
            }
        }
        sbv.append("}");
        return sbv.toString();
    }
}
