package by.it.hutnik.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Vector vec = new Vector("{1.0, 2.0, 4.0}");
        Var v1 = new Scalar(3.1415);
        Var v2 = new Vector (vec);
        System.out.println(v1);
        System.out.println(v2);
    }
}
