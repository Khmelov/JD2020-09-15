package by.it.siarheikorbut.jd02_04;

import java.util.Arrays;

class Vector extends Var {

  private double [] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
      this.value = Arrays.copyOf(value, value.length);
  }

 public Vector (Vector vector) {
  this.value = vector.value;
 }
 public Vector (String strVector) {
        StringBuilder sb= new StringBuilder(strVector);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
     strVector=sb.toString();
     String []arrayString=strVector.split(",");

  this.value= new double[arrayString.length];
    for (int i = 0; i < arrayString.length; i++) {
  value[i]=Double.parseDouble(arrayString[i]);
  }
 }



    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+ ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
             double [] res=Arrays.copyOf(value,value.length);
            if (value.length!=((Vector) other).getSize()){
                throw new CalcException("недопустимый размер векторов.");
            }
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]- ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (value.length!=((Vector) other).getSize()){
                throw new CalcException("недопустимый размер векторов.");
            }
            double [] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else return super.add(other);
    }

    @Override
    public Var mul(Var other)throws CalcException {
        if (other instanceof Scalar){
            double [] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]* ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res=Arrays.copyOf(value,value.length);
            if (value.length!=other.getSize()){
                throw new CalcException("недопустимый размер векторов.");
            }
            double sum=0;
            for (int i = 0; i < res.length; i++) {
                sum=sum+res[i]*((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
        double[]res=new double[value.length];
            for (int i = 0; i < res.length; i++) {
                res[i]=value[i]/((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){  return super.div(other);}
        else if (other instanceof Matrix){  return super.div(other);}
        else  return super.div(other);
    }

    @Override
 public String toString() {
   StringBuilder sb= new StringBuilder("{");
   String delimiter= "";
  for (double v : value) {
   sb.append(delimiter).append(v);
   delimiter=", ";
   }
  sb.append("}");
  return sb.toString();
 }

    @Override
    protected int getSize() {
        return value.length;
        }
}
