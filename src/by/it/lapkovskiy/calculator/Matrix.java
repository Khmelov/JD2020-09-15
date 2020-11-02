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
                st=st.concat(value[i][j]+", ");
            }
            st+=value[i][value[i].length-1]+"}";
            if(i ==value.length-1) break;
            st=st.concat(", ");
        }
        st+="}";
        return st;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getMatrixAddScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.MATRIX)){
            return getMatrixAddMatrix((Matrix) other);
        }
        else return super.add(this);
    }

    private Matrix getMatrixAddMatrix(Matrix other) {
        double [][] sum = new double[this.value.length][this.getValue()[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j]= getValue()[i][j] + other.getValue()[i][j];
            }
        }
        return new Matrix(sum);
    }

    private Matrix getMatrixAddScalar(Scalar other) {
        double [][] sum = new double[this.value.length][this.getValue()[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j]= this.getValue()[i][j] + other.value;
            }
        }
        return new Matrix(sum);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getMatrixSubScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.MATRIX)){
            return getMatrixSubMatrix((Matrix) other);
        } else return other.sub(this);
    }

    private Matrix getMatrixSubMatrix(Matrix other) throws CalcException {
        exceptionLength(other);
        double [][] sub = new double[this.value.length][this.getValue()[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sub[i][j] =this.value[i][j] - other.value[i][j];
            }
        }
        return new Matrix(sub);
    }

    private Matrix getMatrixSubScalar(Scalar other) {
        double [][] sub = new double[this.value.length][this.getValue()[0].length];
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                sub[i][j]= this.getValue()[i][j] - other.value;
            }
        }
        return new Matrix(sub);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            return getMatrixMulScalar((Scalar) other);
        }
        else if(other.toString().matches(Patterns.VECTOR)){
            return getMatrixMulVector((Vector) other);
        }
        else if(other.toString().matches(Patterns.MATRIX)){
            return getMatrixMulMatrix((Matrix) other);
        }
        else return super.mul(this);
    }
    
    private Matrix getMatrixMulMatrix(Matrix other) throws CalcException {
        exceptionLength(other);
        double[][] resultMatrix = new double[other.value[0].length][this.value.length];
        for (int i = 0; i < this.value.length; ++i)
            for (int j = 0; j < other.value.length; ++j)
                for (int k = 0; k < this.value.length; ++k) {
                    resultMatrix[i][j] = resultMatrix[i][j] + other.getValue()[k][j] * this.value[i][k];
                }
        return new Matrix(resultMatrix);
    }

    private Vector getMatrixMulVector(Vector other) {
        double[] resultVector = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < other.value.length; j++) {
                resultVector[i] = resultVector[i] + value[i][j] * other.getValue()[j];
            }
        }
        return new Vector(resultVector);
    }

    private Matrix getMatrixMulScalar(Scalar other) {
        double [][] sum = new double[this.value.length][this.getValue()[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j]= this.getValue()[i][j] * other.value;
            }
        }
        return new Matrix(sum);
    }

    private void exceptionLength(Matrix other) throws CalcException {
        if (other.value[0].length != value.length)
            throw new CalcException(ConsoleRunner.rasMan.get(Message.length_not_equals));
    }

    @Override
    public Var div(Var other) throws CalcException {
       return super.div(this);
    }
}
