package by.it.lapkovskiy.calculator;


import java.util.Arrays;

public class Matrix extends Var {
    public double[][] value;
     double[][] getValue(){
        return value;
    }
   public Matrix(double[][] value){
        this.value = value;
    }
   public Matrix(Matrix matrix){
        this.value = matrix.getValue();
    }
    public Matrix(String strMatrix){
        strMatrix = strMatrix.replace("{{","");
        strMatrix = strMatrix.replace("}}","");
        String[] str = strMatrix.split("},");//
        for (int i = 0; i < str.length; i++) {
          str[i] = str[i].replace("{","");
          str[i] = str[i].replace(" ","");
        }

        String[][] st = new String[str.length][];
        for (int i = 0; i < str.length; i++) {
           st[i] = str[i].split(",");
        }
        double[][] arrDouble = new double[st.length][st[0].length];
        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < st[i].length; j++) {
                arrDouble[i][j] = Double.parseDouble(st[i][j]);
            }
        }
        this.value = Arrays.copyOf(arrDouble,arrDouble.length);
    }

    @Override
    public String toString() {
        String st ="{";
        for (int i = 0; i < value.length; i++) {
            st=st.concat("{");
            for (int j = 0; j < value[i].length-1; j++) {
                st=st.concat(value[i][j]+",");
            }
            st+=value[i][value[i].length-1]+"}";
            if(i ==value.length-1) break;
            st=st.concat(",");
        }
        st+="}";
        return st;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double [][] sum = new double[this.value.length][this.getValue()[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j]= this.getValue()[i][j] + ((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        else if(other instanceof Vector){
            return super.add(this);
        }
        else if(other instanceof Matrix){
            double [][] sum = new double[this.value.length][this.getValue()[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j]= getValue()[i][j] + ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(sum);
        }
        else return super.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double [][] sub = new double[this.value.length][this.getValue()[0].length];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j]= this.getValue()[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(sub);
        }
        else if(other instanceof Vector){
            return super.sub(this);
        }
        else if(other instanceof Matrix){
            if(((Matrix) other).value[0].length!= value.length) throw new CalcException(" length not eq");
            double [][] sub = new double[this.value.length][this.getValue()[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sub[i][j] =this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        } else return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double [][] sum = new double[this.value.length][this.getValue()[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j]= this.getValue()[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        else if(other instanceof Vector){
            double[] resultVector = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).value.length; j++) {
                    resultVector[i] = resultVector[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(resultVector);
        }
        else if(other instanceof Matrix){
            if(((Matrix) other).value[0].length!= value.length) throw new CalcException(" length not eq");
            double[][] resultMatrix = new double[((Matrix) other).value[0].length][this.value.length];
            for (int i = 0; i < this.value.length; ++i)
                for (int j = 0; j < ((Matrix) other).value.length; ++j)
                    for (int k = 0; k < this.value.length; ++k) {
                        resultMatrix[i][j] = resultMatrix[i][j] + ((Matrix) other).getValue()[k][j] * this.value[i][k];
                    }
            return new Matrix(resultMatrix);
        }
        else return super.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
       return super.div(this);
    }
}
