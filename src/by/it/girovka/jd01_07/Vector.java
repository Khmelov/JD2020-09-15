package by.it.girovka.jd01_07;

import java.util.Arrays;

class Vector extends Var {
 private double[] value;

 public Vector(double[] value){

  this.value = Arrays.copyOf(value,value.length);
 }

 public Vector(Vector other){
  double[] tmp = other.value;
  this.value = Arrays.copyOf(tmp, tmp.length);
 }

 public Vector(String strValue){

 }

 @Override
 public String toString() {
  StringBuilder out = new StringBuilder();
  out.append('{');
  String delimiter= "";
  for (double element: value){
   out.append(delimiter).append(element);
   delimiter=", ";
  }
  out.append('}');
  return out.toString();

 }
}