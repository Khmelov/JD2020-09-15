package by.it.girovka.jd01_07;

public class Runner {
    public static void main(String[] args) {
       double[] vvv = {1, 2, 4, 8};
       Var v1 = new Vector(vvv);

        System.out.println(v1.toString());
        Scalar v2 = new Scalar ("77.000000");
        System.out.println(v2);
        Var v3 = new Scalar(v2);

        System.out.println(v2);


    }
}
