package by.it.fedorinhyk.jd02_04;

import java.util.Arrays;

class Matrix extends Var {
    public double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        double[][] mat = matrix.value;
        this.value = Arrays.copyOf(mat, mat.length);
    }

    Matrix(String strMatrix) {
        String mat = strMatrix;
        mat = mat.replaceFirst("\\{\\{","")
                .replaceFirst("}}","").replaceAll("\\s+","");
        String[] matvec = mat.split("},\\{");
        String[][] matstr = new String[matvec.length][];
        for (int i = 0; i < matvec.length; i++) {
            matstr[i] = matvec[i].split(",");
        }
        double[][] fin = new double[matvec.length][matstr[0].length];
        for (int i = 0; i < matstr.length; i++) {
            for (int j = 0; j < matstr[0].length; j++) {
                fin[i][j] = Double.parseDouble(matstr[i][j]);
            }
        }
        this.value = fin;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] sum = new  double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                sum[i]= Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j]+= otherScalar.getValue();
                }
            }
            return new Matrix(sum);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double [][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                sum[i]= Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j]+= otherMatrix.value[i][j];
                }
            }
            if (otherMatrix.value.length != value.length){
                throw new CalcException("Wrong matrix");
            }
            return new Matrix(sum);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double [][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                sub[i]= Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j]-= otherScalar.getValue();
                }
            }
            return new Matrix(sub);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double [][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                sub[i]= Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j]-= otherMatrix.value[i][j];
                }
            }
            if (otherMatrix.value.length != value.length) {
                throw new CalcException("Wrong matrix");
            }
            return new Matrix(sub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                mul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] =mul[i][j]*otherScalar.getValue();
                }
            }
            return new Matrix(mul);
        } else if (other instanceof Vector) {
            Vector otherVector = (Vector) other;
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                mul[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[] mulresult = new double[mul.length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < otherVector.getValue().length; j++) {
                    mulresult[i] += mul[i][j] * otherVector.getValue()[j];
                }
            }
            return new Vector(mulresult);
        } else if (other instanceof Matrix) {
            Matrix otherMatrix = (Matrix) other;
            double [][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                mul[i]= Arrays.copyOf(this.value[i],this.value[i].length);
            }
            double[][] mulresult = new double[mul.length][otherMatrix.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < otherMatrix.value[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length; k++)
                        mulresult[i][j] = mulresult[i][j] + mul[i][k] * otherMatrix.value[k][j];
                }
            }
            if (otherMatrix.value.length != value.length) {
                throw new CalcException("Wrong matrix");
            }
            return new Matrix(mulresult);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                div[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < div.length; i++) {
                for (int j = 0; j < div[i].length; j++) {
                    div[i][j] /= otherScalar.getValue();
                }
            }
            if ( otherScalar.getValue()==0)
                throw new CalcException("Division by zero");
            return new Matrix(div);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sbv = new StringBuilder();
        sbv.append("{");
        for (int i = 0; i < value.length ; i++) {
            sbv.append("{");
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {
                sbv.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            sbv.append("}");
            if(i< (value.length-1)){
                sbv.append(delimiter);
            }
        }
        sbv.append("}");
        return sbv.toString();
    }
}
